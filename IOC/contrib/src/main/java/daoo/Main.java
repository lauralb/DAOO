package daoo;

import daoo.server.TaskExecutorProvider;
import daoo.server.TaskServer;
import daoo.server.Executor;
import daoo.servers.DaooEncoderServer;
import daoo.servers.DaooTaskServer;
import daoo.tasks.EncoderTask;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        TaskServer server = new DaooEncoderServer();
        Executor executor = new Executor();
        TaskExecutorProvider taskExecutorProvider = new TaskExecutorProvider();
        executor.setTaskExecutor(taskExecutorProvider.getTaskExecutor());
        server.start(executor, 8080);
    }
}
