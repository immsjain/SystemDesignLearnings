import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        File file = new File("oracle",new Data("Hello"));
        File file2 = new File("Swiggy",new Data("Hello"));
        System.out.println(file.getName());

        fileSystem.addFile(file,"/Shubham/Jain");
        fileSystem.addFile(file2,"/Shubham");

        Directory directory = new Directory("Shiv","/Shubham");
        fileSystem.addFile(file,"/Shubham/vaibhav");
        Set<String> st = fileSystem.listALlChildren("/Shubham");
        System.out.println(st);
        fileSystem.addDirectory(directory,"/Shubham");
        st = fileSystem.listALlChildren("/Shubham");
        System.out.println(st);
    }
}