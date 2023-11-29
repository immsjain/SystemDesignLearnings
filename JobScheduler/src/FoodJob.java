public class FoodJob extends Job{
    public FoodJob(String action) {
        super(action);
    }

    @Override
    public void run() {
        System.out.println("Food Job has been started" + super.getAction());
    }
}
