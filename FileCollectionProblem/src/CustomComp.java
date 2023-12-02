import java.util.Comparator;

public class CustomComp implements Comparator<UCollection> {
    @Override
    public int compare(UCollection o1, UCollection o2) {
        return Integer.compare(o1.getSize(),o2.getSize());
    }
}
