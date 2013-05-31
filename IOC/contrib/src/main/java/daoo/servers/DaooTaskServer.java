package daoo.servers;

import com.sun.istack.internal.NotNull;
import daoo.server.Executor;
import daoo.server.Task;
import daoo.server.TaskServer;
import daoo.tasks.EchoTask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class DaooTaskServer implements TaskServer {

    @Override
    public void start(@NotNull Executor executor, @NotNull int port) {
        ServerSocket serverSocket=null;
        try {
            serverSocket =new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            try{
                Socket socket=serverSocket.accept();
                Task task= new EchoTask(socket);
                executor.execute(task);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
