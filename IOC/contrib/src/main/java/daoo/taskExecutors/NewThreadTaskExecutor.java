package daoo.taskExecutors;

import com.sun.istack.internal.NotNull;
import daoo.server.Task;
import daoo.server.TaskExecutor;

public class NewThreadTaskExecutor implements TaskExecutor {
    @Override public void execute(@NotNull Task task) {
        new Thread(task).start();
    }
}
