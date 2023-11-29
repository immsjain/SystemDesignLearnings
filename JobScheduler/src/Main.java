import java.util.Date;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        JobScheduler jobScheduler = MapBasedJobScheduler.getInstance();
        Job job1 = new DanceJob("temprary");
        Job job2 = new InterviewJob("Atlassian interview");
        Job job3 = new CodingJob("DP");
        Job job4 = new FoodJob("Baati");
        Request request1 = new Request(job1,new Date(2023,7,21,1,35,23));
        Request request2 = new Request(job2,new Date(2023,7,21,1,35,23));
        Request request3 = new Request(job3,new Date(2023,8,21,1,35,23));
        Request request4 = new Request(job4,new Date(2023,7,21,1,35,23));

        jobScheduler.scheduleReq(request1);
        jobScheduler.scheduleReq(request2);
        jobScheduler.scheduleReq(request3);
        jobScheduler.scheduleReq(request4);
        jobScheduler.executeRequest(new Date(2023,7,21,1,35,23));

        JobExecutionThread jobExecutionThread = new JobExecutionThread();
        Thread t1 = new Thread(jobExecutionThread);
        t1.start();

    }
}