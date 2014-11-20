package daoo.taskExecutors;

import com.sun.istack.internal.NotNull;
import daoo.server.Task;
import daoo.server.TaskExecutor;

import java.util.LinkedList;
import java.util.Queue;

public class PoolThreadTaskExecutor implements TaskExecutor {

    //private final ExecutorService executorService;
    private final Queue<Task> tasks;
    private final Thread[] threads;
    private final int size;
    private int nextThread;


    public PoolThreadTaskExecutor(int size){
        this.size = size;
        nextThread = 0;
        tasks = new LinkedList<Task>();
        threads = new Thread[size];
        for (Thread thread : threads){
           thread = new Thread ();
        }
    }

    @Override
    public void execute(@NotNull Task task) {
        tasks.add(task);
        threads[nextThread].start();
        threads[nextThread] = buildThread();
        nextThread = (nextThread +1) % size;
    }

    private Thread buildThread() {
        return new Thread() {
            @Override
            public void run() {
                System.out.println("Running in thread: " + getName() + " - NextAvailable: " + nextThread);
                tasks.remove().run();
            }
        };
    }


}
