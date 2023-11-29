import java.util.Date;
import java.util.List;

public interface JobScheduler {
    boolean scheduleReq(Request req);

    boolean executeRequest(Date date);

    List<Job> getAllScheduledReq(Date date);
}
