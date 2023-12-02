// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static  int test() throws NoSuchFieldException {
        try {
            System.out.println("try1");
            //int x = 15/0;
            return 2;
            //System.out.println("try2");
        }catch (Exception e){
            System.out.println("catch1");
            return 3;
            //System.out.println("catch2");
        }finally {
            System.out.println("final1");
            throw new NoSuchFieldException();
            //System.out.println("final2");
        }
    }

    public static void main(String[] args) throws NoSuchFieldException {

        int a = test();
        System.out.println(a);
    }
}