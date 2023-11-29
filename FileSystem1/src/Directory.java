import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory extends Children{
    private Map<String,Children> childrenMap;

    public Directory(String name,String path) {
        super(name,path);
        childrenMap = new HashMap<>();
    }


    public Map<String, Children> getChildrenMap() {
        return childrenMap;
    }

    public void setChildrenMap(Map<String, Children> childrenMap) {
        this.childrenMap = childrenMap;
    }
}
