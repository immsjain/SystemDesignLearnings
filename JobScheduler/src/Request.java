import java.util.Date;

public class Request {
    private Job job;
    Date date;

    public Request(Job job, Date date) {
        this.job = job;
        this.date = date;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
