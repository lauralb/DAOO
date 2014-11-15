package daoo.server;


import com.sun.istack.internal.NotNull;
import daoo.exceptions.Exception503;

public class Executor{

    private TaskExecutor taskExecutor;

    public void setTaskExecutor(TaskExecutor taskExecutor){
        this.taskExecutor = taskExecutor;
    }

    public void execute(@NotNull Task task) {
        try {
            taskExecutor.execute(task);
        } catch (Exception503 exception503) {
            System.out.println(exception503.getMessage());
        }
    }

}
