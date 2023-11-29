public class CodingJob extends Job{
    public CodingJob(String action) {
        super(action);
    }

    @Override
    public void run() {
        System.out.println("Coding Job has been started" + super.getAction());
    }
}
