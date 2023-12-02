import java.util.ArrayList;
import java.util.List;

public class UCollection implements Comparable<UCollection>{
    private String name;
    private int size;
    private List<File>files;

    public UCollection(String name, int size) {
        this.name = name;
        this.size = size;
        files = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void addFile(File file){
        this.getFiles().add(file);
        this.size += file.getSize();
    }

    @Override
    public int compareTo(UCollection o) {
        return o.getSize()-this.getSize();
    }
}
