import java.util.Collection;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.txt", 200);
        File file3 = new File("file3.txt", 200);
        File file4 = new File("file4.txt", 300);
        File file5 = new File("file5.txt", 100);
        FileSystem fileSystem = new FileSystem();
        fileSystem.addFile(file1);
        fileSystem.addFile(file2);
        fileSystem.addFile(file3);
        fileSystem.addFile(file4);
        fileSystem.addFile(file5);
        UCollection collection1 = new UCollection("collection1",0);
        UCollection collection2 = new UCollection("collection2",0);
        fileSystem.addFileCollection(file2,collection1);
        fileSystem.addFileCollection(file3,collection1);
        fileSystem.addFileCollection(file4,collection2);
        System.out.println("total fileSize: "+ fileSystem.getTotalFileSize());
        List<UCollection> list = fileSystem.getTopCollections(2);
        for (UCollection u: list
             ) {
            System.out.println(u.getName());
        }
    }
}