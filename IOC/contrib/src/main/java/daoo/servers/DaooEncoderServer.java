package daoo.servers;

import com.sun.istack.internal.NotNull;
import daoo.ioc.EncodeStrategyProvider;
import daoo.ioc.MessageEncoderProvider;
import daoo.server.Executor;
import daoo.server.Task;
import daoo.server.TaskServer;
import daoo.tasks.EncoderTask;
import daoo.tasks.InfiniteTask;
import daoo.tasks.SleepyTask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 28/06/13
 * Time: 10:44
 */
public class DaooEncoderServer implements TaskServer {

    private MessageEncoderProvider messageEncoderProvider;
    private EncodeStrategyProvider encodeStrategyProvider;

    public void start(@NotNull Executor executor, @NotNull int port) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Task task = new EncoderTask(socket, messageEncoderProvider, encodeStrategyProvider);
                executor.execute(task);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setMessageEncoderProvider(MessageEncoderProvider messageEncoderProvider){
        this.messageEncoderProvider = messageEncoderProvider;
    }

     public void setEncodeStrategyProvider (EncodeStrategyProvider encodeStrategyProvider){
         this.encodeStrategyProvider = encodeStrategyProvider;
    }

}
