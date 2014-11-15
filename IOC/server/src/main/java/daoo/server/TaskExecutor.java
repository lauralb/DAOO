package daoo.server;

import com.sun.istack.internal.NotNull;
import daoo.exceptions.Exception503;

public interface TaskExecutor {

    /**
     * Executes the given task at some time in the future. The task
     * may execute in a new thread, in a pooled thread, and so on,
     * depending on the implementation.
     */
    void execute(@NotNull Task task) throws Exception503;
}
