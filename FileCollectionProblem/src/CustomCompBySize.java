import java.util.Comparator;

public class CustomCompBySize implements Comparator<UCollection> {
    @Override
    public int compare(UCollection o1, UCollection o2) {
        return o2.getSize()-o1.getSize();
    }
}
