import java.util.Date;

public class JobExecutionThread extends Thread {
    @Override
    public void run() {
        JobScheduler jobScheduler= MapBasedJobScheduler.getInstance();
        while (true){
            jobScheduler.executeRequest(new Date());
        }
    }
}
