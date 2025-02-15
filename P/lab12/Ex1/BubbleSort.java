import java.util.Comparator;
import java.util.List;

public class BubbleSort extends Sorter {
    @Override
    protected void doSort(List<MobilePhone> phones, Comparator<MobilePhone> comparator) {
        for (int i = 0; i < phones.size(); i++) {
            for (int j = 0; j < phones.size() - i - 1; j++) {
                if (comparator.compare(phones.get(j), phones.get(j + 1)) > 0) {
                    MobilePhone temp = phones.get(j);
                    phones.set(j, phones.get(j + 1));
                    phones.set(j + 1, temp);
                }
            }
        }
    }
}
