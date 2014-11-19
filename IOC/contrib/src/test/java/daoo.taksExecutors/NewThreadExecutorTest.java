package daoo.taksExecutors;

import daoo.MockingFactory;
import daoo.ioc.EncodeStrategyProvider;
import daoo.ioc.MessageEncoderProvider;
import daoo.server.Executor;
import daoo.servers.DaooEncoderServer;
import daoo.taskExecutors.NewThreadTaskExecutor;

/**
 * Created by IntelliJ IDEA.
 * User: Laura
 * Date: 17/11/14
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */
public class NewThreadExecutorTest {

    public NewThreadExecutorTest(){
        MessageEncoderProvider messageEncoderProvider = MockingFactory.mockedMessageEncoderProvider();
        EncodeStrategyProvider encodeStrategyProvider = MockingFactory.mockedEncodeStrategyProvider();

        DaooEncoderServer daooEncoderServer = new DaooEncoderServer();
        daooEncoderServer.setMessageEncoderProvider(messageEncoderProvider);
        daooEncoderServer.setEncodeStrategyProvider(encodeStrategyProvider);

        //
        Executor executor = new Executor();
        executor.setTaskExecutor(new NewThreadTaskExecutor());
        daooEncoderServer.start(executor,8080);

    }

}
