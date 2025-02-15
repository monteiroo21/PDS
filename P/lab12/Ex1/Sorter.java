import java.util.Comparator;
import java.util.List;

public abstract class Sorter {
    public final void sort(List<MobilePhone> phones, Comparator<MobilePhone> comparator) {
        if (phones == null || comparator == null) {
            throw new IllegalArgumentException("phones and comparator must not be null");
        }
        doSort(phones, comparator);
    }

    protected abstract void doSort(List<MobilePhone> phones, Comparator<MobilePhone> comparator);
}
