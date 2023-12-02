import java.util.*;

public class MyDirectory implements Entity{
    private String name;
    private List<Entity> list;
    private Map<String,Entity>map;

    public MyDirectory(String name) {
        this.name = name;
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entity> getList() {
        return list;
    }

    public void setList(List<Entity> list) {
        this.list = list;
    }

    public Map<String, Entity> getMap() {
        return map;
    }

    public void setMap(Map<String, Entity> map) {
        this.map = map;
    }

    public int getSize() {
        int size=0;
        for (Entity e :this.getList()) {
            size += e.getSize();
        }
        return size;
    }


    public void sort(){
        Collections.sort(list,new CustomSortBySize());
    }

    public void addEntity(Entity e){
        this.getList().add(e);
    }

}
