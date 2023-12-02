public class xyz implements ABC, BCD{

    @Override
    public void getInt() {
        ABC.super.getInt();
    }
}
