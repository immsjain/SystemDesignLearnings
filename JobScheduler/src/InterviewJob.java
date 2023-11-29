public class InterviewJob extends Job{
    public InterviewJob(String action) {
        super(action);
    }

    @Override
    public void run() {
        System.out.println("Interview Job has been started" + super.getAction());
    }
}
