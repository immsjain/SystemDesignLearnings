import java.util.*;
import java.util.Collection;

public class FileSystem {
    private List<File>files;
    private List<UCollection>collectionList;
    private int totalFileSize;
    private Map<File,List<UCollection>>map;

    public FileSystem() {
        this.totalFileSize = 0;
        files = new ArrayList<>();
        map = new HashMap<>();
        collectionList = new ArrayList<>();
    }

    public void addFile(File file){
        files.add(file);
        totalFileSize += file.getSize();
        if(!map.containsKey(file)){
            map.put(file,new ArrayList<>());
        }
    }
    public void addFileCollection(File file,UCollection collection){
        collection.addFile(file);
        if(!map.containsKey(file)){
            map.put(file,new ArrayList<>());
        }
        map.get(file).add(collection);
        if(!collectionList.contains(collection)){
            collectionList.add(collection);
        }
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public int getTotalFileSize() {
        return totalFileSize;
    }

    public void setTotalFileSize(int totalFileSize) {
        this.totalFileSize = totalFileSize;
    }

    public Map<File, List<UCollection>> getMap() {
        return map;
    }

    public void setMap(Map<File, List<UCollection>> map) {
        this.map = map;
    }
    public List<UCollection> getTopCollections(int k) {
        List<UCollection> list = collectionList;

//        Comparator<UCollection> customComp = new Comparator<UCollection>() {
//            @Override
//            public int compare(UCollection o1, UCollection o2) {
//                return Integer.compare(o2.getSize(), o1.getSize()); // Compare in descending order
//            }
//        };

        Collections.sort(list);

        // Check if k is greater than the list size
        int sublistSize = Math.min(k, list.size());

        List<UCollection> ans =  list.subList(0, sublistSize);
        return ans;
    }
}
