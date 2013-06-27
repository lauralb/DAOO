package daoo.taskExecutors;

import com.sun.istack.internal.NotNull;
import daoo.server.Task;
import daoo.server.TaskExecutor;

import java.util.ArrayList;
import java.util.List;

public class QueuedTaskExecutor  extends Thread implements TaskExecutor{

    private final List<Task> tasks;
    private Thread thread;

    public QueuedTaskExecutor() {
        tasks = new ArrayList<Task>();
        thread = new Thread();
    }

    @Override
    public void execute(@NotNull Task task) {
          tasks.add(task);
    }

    public void run(){
        while(true){
            if(!thread.isAlive() && !tasks.isEmpty()){
                thread = new Thread(tasks.remove(0));
                thread.start();
            }
        }

    }

}
