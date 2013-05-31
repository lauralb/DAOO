package daoo.server;


import com.sun.istack.internal.NotNull;

public class Executor{

    private TaskExecutor taskExecutor;

    public void setTaskExecutor(TaskExecutor taskExecutor){
        this.taskExecutor = taskExecutor;
    }

    public void execute(@NotNull Task task){
        taskExecutor.execute(task);
    }

}
