import java.util.Date;

public class JobExecutionThread implements Runnable{
    @Override
    public void run() {
        JobScheduler jobScheduler= MapBasedJobScheduler.getInstance();
        while (true){
            jobScheduler.executeRequest(new Date());
        }
    }
}
