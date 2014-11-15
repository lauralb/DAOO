package daoo.taskExecutors;

import com.sun.istack.internal.NotNull;
import daoo.server.Task;
import daoo.server.TaskExecutor;

import java.util.LinkedList;
import java.util.Queue;

public class PoolThreadTaskExecutor implements TaskExecutor {

    //private final ExecutorService executorService;
    private final Queue<Task> tasks;    // hace falta??
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
        // que el thread[nextThread] ejecute la task...
        // reglas??
        nextThread = (nextThread +1) % size;
    }


}
