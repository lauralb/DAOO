package daoo.servers;


import com.sun.istack.internal.NotNull;
import daoo.server.Executor;
import daoo.server.Task;
import daoo.server.TaskServer;
import daoo.tasks.EchoTask;
import daoo.tasks.EncoderTask;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DaooEncoderServer implements TaskServer {

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
                    Task task= new EncoderTask(socket);
                    executor.execute(task);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }


    }
