package daoo.server;

import java.io.*;
import java.net.Socket;

public abstract class Task implements Runnable {

    protected final Socket socket;

    public Task(Socket socket) { this.socket = socket; }

    @Override public void run() {
        try {
            task();
            close();
        } catch (IOException e) {
            throw new RuntimeException("Task socket io exception!", e);
        }
    }

    protected abstract void task() throws IOException;

    /** To be called before finishing run execution. */
    protected void close() throws IOException {
        socket.close();
    }

    protected void print(String msg) {
        System.out.println("Task with " + socket + " at " + System.currentTimeMillis() + " " + msg);
    }

    /** Sleepy task: it takes given sleep time to run. */
    //public static Task sleepy(Socket socket, long sleep) { return new SleepyTask(socket, sleep); }

    /** Infinite task: it takes for ever... */
    //public static Task infinite(Socket socket) { return new InfiniteTask(socket); }

    /** Echo task: it takes for ever... */
    //public static Task echo(Socket socket) { return new EchoTask(socket); }

    //public static Task encoder(Socket socket) { return new EncoderTask(socket); }

    protected String getHeaderPath(String header) {
        final int method = header.indexOf("GET /");
        if(method == -1) throw unsupported("Unsupported HTTP Method! GET only!");
        final int protocol = header.indexOf("HTTP/1.");
        if(protocol == -1) throw unsupported("Unsupported HTTP Protocol! HTTP/1.* only!");
        return header.substring(method + 4, protocol);
    }


    private UnsupportedOperationException unsupported(String s) {
        return new UnsupportedOperationException(s);
    }
}
