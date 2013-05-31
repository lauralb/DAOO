package daoo.tasks;

import daoo.server.Task;

import java.io.IOException;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 30/05/13
 * Time: 23:37
 * To change this template use File | Settings | File Templates.
 */
public class InfiniteTask extends Task {

    public InfiniteTask(Socket socket) { super(socket); }

    @Override public void task() throws IOException {
        //super.task();
        print("endless...");
        endless();
    }

    private void endless() {
        //noinspection InfiniteLoopStatement,StatementWithEmptyBody
        for (;;) {}
    }

}
