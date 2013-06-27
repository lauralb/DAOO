package daoo.server;

import java.util.ServiceLoader;

/**
 * Created with IntelliJ IDEA.
 * User: laura
 * Date: 27/06/13
 * Time: 16:06
 */
public class TaskExecutorProvider{

    public TaskExecutor getTaskExecutor(){
        final ServiceLoader<TaskExecutor> loader = ServiceLoader.load(TaskExecutor.class);
        for (TaskExecutor taskExecutor : loader){
            System.out.println(taskExecutor.getClass().getName());
            return taskExecutor;
        }
        return null;
    }

}
