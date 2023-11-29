import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FileSystem {
    private Directory root;

    public FileSystem() {
        this.root = new Directory("Root","/");
    }

    public Directory getRoot() {
        return root;
    }

    public void setRoot(Directory root) {
        this.root = root;
    }

    public boolean addFile(File file, String path){
        List<String> list = List.of(path.split("/"));
        Directory itr = root;
        StringBuilder p = new StringBuilder();
        p.append("/");
        for (String str: list) {
            if(str.isEmpty()){
                continue;
            }
            if(!itr.getChildrenMap().containsKey(str)){
                itr.getChildrenMap().put(str,new Directory(str,p+"/"+str));
            }else if(itr.getChildrenMap().get(str) instanceof File){
                return false;
            }
            itr = (Directory) itr.getChildrenMap().get(str);
            p.append("/"+str);
        }
        String s= file.getName();
        if(itr.getChildrenMap().size()==0 || !itr.getChildrenMap().containsKey(s)){
            itr.getChildrenMap().put(s,file);
            return true;
        }
        return false;
    }

    public boolean addDirectory(Directory dir, String path){
        List<String> list = List.of(path.split("/"));
        Directory itr = root;
        StringBuilder p = new StringBuilder();
        p.append("/");
        for (String str: list) {
            if(str.isEmpty()){
                continue;
            }
            if(!itr.getChildrenMap().containsKey(str)){
                itr.getChildrenMap().put(str,new Directory(str,p+"/"+str));
            }else if(itr.getChildrenMap().get(str) instanceof File){
                return false;
            }
            itr = (Directory) itr.getChildrenMap().get(str);
            p.append("/"+str);
        }
        if(!itr.getChildrenMap().containsKey(dir.getName())){
            itr.getChildrenMap().put(dir.getName(),dir);
            return true;
        }
        return false;
    }

    public Set<String> listALlChildren(String path){
        List<String> list = List.of(path.split("/"));
        Directory itr = root;
        StringBuilder p = new StringBuilder();
        p.append("/");
        for (String str: list) {
            if(str.isEmpty()){
                continue;
            }
            if(!itr.getChildrenMap().containsKey(str)){
                return null;
            }else if(itr.getChildrenMap().get(str) instanceof File){
                return null;
            }
            itr = (Directory) itr.getChildrenMap().get(str);
        }
        System.out.println("Total count : " + itr.getChildrenMap().size());
        return itr.getChildrenMap().keySet();
    }
}
