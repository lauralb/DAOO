package daoo.taksExecutors;

import com.sun.istack.internal.NotNull;
import daoo.MockingFactory;
import daoo.encoder.SimpleEncoder;
import daoo.exceptions.Exception503;
import daoo.ioc.EncodeStrategyProvider;
import daoo.ioc.MessageEncoderProvider;
import daoo.server.Executor;
import daoo.server.Task;
import daoo.servers.DaooEncoderServer;
import daoo.taskExecutors.NewThreadTaskExecutor;
import daoo.taskExecutors.PoolThreadTaskExecutor;
import daoo.tasks.EchoTask;
import daoo.tasks.InfiniteTask;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.asm.util.CheckClassAdapter;

import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: Laura
 * Date: 17/11/14
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */

public class PoolThreadExecutorTest {

    private final PoolThreadTaskExecutor executor = new PoolThreadTaskExecutor(2);

    @Test
    public void quotaNotExceded() throws Exception503 {
        Task task= MockingFactory.mockedTask();
        executor.execute(task);
        Mockito.verify(task).run();
    }

    @Test(expected=Exception503.class)
   public void quotaExceded() throws Exception503{
       Socket socket = new MockingFactory().mockedSocket();
       Task task= new InfiniteTask(socket);
       for(int i=0;i<8;i++){
           executor.execute(task);
       }
   }



    public PoolThreadExecutorTest(){

    }

}
