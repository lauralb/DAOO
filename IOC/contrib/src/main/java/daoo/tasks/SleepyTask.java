package daoo.tasks;

import java.io.IOException;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 30/05/13
 * Time: 23:30
 * To change this template use File | Settings | File Templates.
 */

public class SleepyTask extends EchoTask {
    private final long sleep;

    public SleepyTask(Socket socket, long sleep) {
        super(socket);
        this.sleep = sleep;
    }

    @Override public void task() throws IOException {
        super.task();
        print("sleeping...");
        sleep();
        print("waking up...");
    }

    private void sleep() {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            throw new RuntimeException("Sleepy task interrupted!", e);
        }
    }
}
