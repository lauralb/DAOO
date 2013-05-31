package daoo.server;

import com.sun.istack.internal.NotNull;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executor;


public class DaooTaskServer implements TaskServer {

    @Override public void start(@NotNull Executor executor, int port) {
        ServerSocket serverSocket=null;
        try {
            serverSocket =new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            try{
               /* Socket socket=serverSocket.accept();
                Task task= new Task.encoder(socket);
                executor.execute(task);

               */
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
