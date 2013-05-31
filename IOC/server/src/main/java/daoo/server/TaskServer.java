package daoo.server;

import com.sun.istack.internal.NotNull;


public interface TaskServer {

    /** Start server with specified executor on specified port. */
    void start(@NotNull final Executor executor, @NotNull int port);
}
