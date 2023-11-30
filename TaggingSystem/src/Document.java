import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Document {
    private String data;
    Set<Tag> tags;

    public Document(String data) {
        this.data = data;
        tags = new HashSet<>();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

}
