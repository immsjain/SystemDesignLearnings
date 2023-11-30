import java.util.HashMap;
import java.util.Map;

public class RouteElement {
    private String value;
    Map<String,RouteElement> map;

    public RouteElement(String value) {
        this.value = value;
        this.map = new HashMap<>();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, RouteElement> getMap() {
        return map;
    }

    public void setMap(Map<String, RouteElement> map) {
        this.map = map;
    }
}
