package daoo.taskExecutors;

import com.sun.istack.internal.NotNull;
import daoo.exceptions.Exception503;
import daoo.server.Task;
import daoo.server.TaskExecutor;

import java.util.*;

public class PoolThreadTaskExecutor implements TaskExecutor {

    private final List<Task> tasks;
    private final Thread[] threads;
    private final int size;

    public PoolThreadTaskExecutor(int size){
        this.size = size;
        tasks = Collections.synchronizedList(new ArrayList<Task>());
        threads = new Thread[size];
        for (int i=0;i<size;i++){
           threads[i] = new Thread ();
        }
    }
    public PoolThreadTaskExecutor() {
        this(4);
    }
    @Override
    public void execute(@NotNull Task task) throws Exception503 {
        tasks.add(task);
        boolean error=true;
        for (int i=0;i<size;i++){
            if(threads[i].getState().equals(Thread.State.TERMINATED)||threads[i].getState().equals(Thread.State.NEW)){
                threads[i]=buildThread();
                threads[i].start();
                error=false;
                break;
            }
        }
        if(error)
            throw new Exception503("Pool quota exceded.");
    }

    private Thread buildThread() {
        return new Thread() {
            @Override
            public void run() {
                System.out.println("Running in thread: " + getName() );
                tasks.remove(0).run();
            }
        };
    }


}
