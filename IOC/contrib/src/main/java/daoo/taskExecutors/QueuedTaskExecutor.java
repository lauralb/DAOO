package daoo.taskExecutors;

import com.sun.istack.internal.NotNull;
import daoo.exceptions.Exception503;
import daoo.server.Task;
import daoo.server.TaskExecutor;

import java.util.LinkedList;
import java.util.Queue;

public class QueuedTaskExecutor  extends Thread implements TaskExecutor{

    private final Queue<Task> tasks;
    private final int maxSize;
    private Thread thread;

    public QueuedTaskExecutor(@NotNull int maxSize) {
        this.maxSize = maxSize;
        tasks = new LinkedList<Task>();
        thread = new Thread();
    }

    @Override
    public void execute(@NotNull Task task) throws Exception503 {
        if(tasks.size() <= maxSize){
            tasks.add(task);
        }else{
            throw new Exception503("Max size of queue was exceeded.");
        }
    }

    public void run(){
        while(true){
            if(!thread.isAlive() && !tasks.isEmpty()){
                thread = new Thread(tasks.remove());
                thread.start();
            }
        }
    }

}
