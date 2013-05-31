package daoo.taskExecutors;

import com.sun.istack.internal.NotNull;
import daoo.server.Task;
import daoo.server.TaskExecutor;

import java.util.ArrayList;
import java.util.List;

public class QueuedTaskExecutor implements TaskExecutor {

    private List<Task> tasks;

    public QueuedTaskExecutor() {
        this.tasks = new ArrayList<Task>();
    }

    @Override public void execute(@NotNull Task task) {
        if(!tasks.isEmpty()){
          tasks.add(task);
        }else{
          new Thread(task).run();
        }
        while(!tasks.isEmpty()){
            Thread t = new Thread(tasks.remove(0));
            t.run();
            while(t.isAlive()){

            }
        }
    }
}
