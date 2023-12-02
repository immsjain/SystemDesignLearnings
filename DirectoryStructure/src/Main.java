import java.util.Dictionary;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        File file1 = new File("Shubham","coding Assignment",400);
        File file2 = new File("Shubham","coding Assignment",200);
        File file3 = new File("Shubham","coding Assignment",300);
        File file4 = new File("Shubham","coding Assignment",400);
        File file5 = new File("Shubham","coding Assignment",500);

        MyDirectory directory1 = new MyDirectory("dShubham");
        MyDirectory directory2 = new MyDirectory("dJain");

        directory1.addEntity((Entity) directory2);;
        directory2.addEntity(file1);
        System.out.println(file1.getSize());
        System.out.println(directory1.getSize());
        System.out.println(directory2.getSize());
        directory1.addEntity(file2);
        System.out.println(file1.getSize());
        System.out.println(directory1.getSize());
        System.out.println(directory2.getSize());
        directory1.sort();
        System.out.println(directory1.getList());

    }
}