package daoo.server;

import com.sun.istack.internal.NotNull;

public class NewThreadTaskExecutor implements TaskExecutor {
    @Override public void execute(@NotNull Task task) {
        new Thread(task).start();
    }
}
