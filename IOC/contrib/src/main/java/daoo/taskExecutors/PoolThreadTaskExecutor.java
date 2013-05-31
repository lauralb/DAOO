package daoo.taskExecutors;

import com.sun.istack.internal.NotNull;
import daoo.server.Task;
import daoo.server.TaskExecutor;

import java.util.LinkedList;
import java.util.List;

public class PoolThreadTaskExecutor implements TaskExecutor {

    private final List<Thread> threads;

    public PoolThreadTaskExecutor(){
        threads = new LinkedList<Thread>();
        for (int i = 0; i < 5; i++) {
          threads.add(new Thread());
        }
    }

    @Override public void execute(@NotNull Task task) {

        throw new RuntimeException("To be implemented!");
    }
}
