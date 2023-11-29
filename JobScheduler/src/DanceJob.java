public class DanceJob extends Job{
    public DanceJob(String action) {
        super(action);
    }

    @Override
    public void run() {
        System.out.println("Dance Job has been started" + super.getAction());
    }
}
