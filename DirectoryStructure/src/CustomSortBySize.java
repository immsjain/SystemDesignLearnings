import java.util.Comparator;

public class CustomSortBySize implements Comparator<Entity> {
    @Override
    public int compare(Entity o1, Entity o2) {
        return o1.getSize()-o2.getSize();
    }
}
