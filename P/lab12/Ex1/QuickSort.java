import java.util.Comparator;
import java.util.List;

public class QuickSort extends Sorter {
    @Override
    protected void doSort(List<MobilePhone> phones, Comparator<MobilePhone> comparator) {
        quickSort(phones, comparator, 0, phones.size() - 1);
    }

    private void quickSort(List<MobilePhone> phones, Comparator<MobilePhone> comparator, int low, int high) {
        if (low < high) {
            int pi = partition(phones, comparator, low, high);
            quickSort(phones, comparator, low, pi - 1);
            quickSort(phones, comparator, pi + 1, high);
        }
    }

    private int partition(List<MobilePhone> phones, Comparator<MobilePhone> comparator, int low, int high) {
        MobilePhone pivot = phones.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(phones.get(j), pivot) < 0) {
                i++;
                MobilePhone temp = phones.get(i);
                phones.set(i, phones.get(j));
                phones.set(j, temp);
            }
        }
        MobilePhone temp = phones.get(i + 1);
        phones.set(i + 1, phones.get(high));
        phones.set(high, temp);
        return i + 1;
    }
}
