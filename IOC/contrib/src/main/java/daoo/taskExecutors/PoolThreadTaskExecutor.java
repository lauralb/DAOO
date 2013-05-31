package daoo.taskExecutors;

import com.sun.istack.internal.NotNull;
import daoo.server.Task;
import daoo.server.TaskExecutor;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolThreadTaskExecutor implements TaskExecutor {

    private final ExecutorService executorService;


    public PoolThreadTaskExecutor(){
        executorService = Executors.newFixedThreadPool(5);
    }

    @Override public void execute(@NotNull Task task) {
        executorService.execute(task);
    }
}
