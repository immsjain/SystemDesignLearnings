import java.util.*;

public class TaggingSystem {
    private Map<Tag, List<Document>> map;
    private static TaggingSystem instance;

    private TaggingSystem() {
        this.map = new HashMap<>();
    }

    public static TaggingSystem getInstance(){
        if(instance==null){
            synchronized (TaggingSystem.class){
                if(instance==null){
                    instance = new TaggingSystem();
                }
            }
        }
        return instance;
    }

    public Map<Tag, List<Document>> getMap() {
        return map;
    }

    public void setMap(Map<Tag, List<Document>> map) {
        this.map = map;
    }

    public boolean addTag(Document document, Tag tag ){
        if(document.getTags().contains(tag)){
            return false;
        }
        if(document.getTags().size()>=10){
            return false;
        }
        document.getTags().add(tag);
        if(!map.containsKey(tag)){
            map.put(tag,new ArrayList<>());
        }
        map.get(tag).add(document);
        return true;
    }

    public List<Document> getAllDocuments(Tag tag){
        return map.get(tag);
    }

    public Set<Tag> getDocumentTags(Document document){
        return document.getTags();
    }
}
