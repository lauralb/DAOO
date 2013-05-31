package daoo.server;

import com.sun.istack.internal.NotNull;

public class PoolThreadTaskExecutor implements TaskExecutor {
    @Override public void execute(@NotNull Task task) {
        throw new RuntimeException("To be implemented!");
    }
}
