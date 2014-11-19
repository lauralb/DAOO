package daoo;

import daoo.ioc.EncodeStrategyProvider;
import daoo.ioc.MessageEncoderProvider;
import daoo.server.Executor;
import daoo.server.TaskExecutorProvider;
import daoo.servers.DaooEncoderServer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DaooEncoderServer server = new DaooEncoderServer();
        Executor executor = new Executor();
        TaskExecutorProvider taskExecutorProvider = new TaskExecutorProvider();
        executor.setTaskExecutor(taskExecutorProvider.getTaskExecutor());

        server.setMessageEncoderProvider(new MessageEncoderProvider());
        server.setEncodeStrategyProvider(new EncodeStrategyProvider());
        server.start(executor, 8080);
    }
}
