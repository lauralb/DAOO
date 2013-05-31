package daoo;

import daoo.servers.DaooEncoderServer;
import daoo.server.TaskServer;
import daoo.server.Executor;
import daoo.servers.DaooTaskServer;
import daoo.taskExecutors.NewThreadTaskExecutor;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        TaskServer server = new DaooTaskServer();
        Executor executor = new Executor();
        executor.setTaskExecutor(new NewThreadTaskExecutor());
        server.start(executor, 8080);
    }
}
