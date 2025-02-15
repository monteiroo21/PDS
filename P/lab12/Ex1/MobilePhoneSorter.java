import java.util.Comparator;
import java.util.List;

public class MobilePhoneSorter {
    private Sorter sorter;

    public MobilePhoneSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public void sort(List<MobilePhone> phones, Comparator<MobilePhone> comparator) {
        sorter.sort(phones, comparator);
    }
}
