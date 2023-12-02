public interface ABC {
    int a=2;

    default void getInt(){
        System.out.println("ABC");
    }
}
