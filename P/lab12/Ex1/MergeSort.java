import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort extends Sorter {
    @Override
    protected void doSort(List<MobilePhone> phones, Comparator<MobilePhone> comparator) {
        mergeSort(phones, comparator, 0, phones.size() - 1);
    }

    private void mergeSort(List<MobilePhone> phones, Comparator<MobilePhone> comparator, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(phones, comparator, low, mid);
            mergeSort(phones, comparator, mid + 1, high);
            merge(phones, comparator, low, mid, high);
        }
    }

    private void merge(List<MobilePhone> phones, Comparator<MobilePhone> comparator, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        List<MobilePhone> left = new ArrayList<>();
        List<MobilePhone> right = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            left.add(phones.get(low + i));
        }
        for (int i = 0; i < n2; i++) {
            right.add(phones.get(mid + 1 + i));
        }

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                phones.set(k, left.get(i));
                i++;
            } else {
                phones.set(k, right.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            phones.set(k, left.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            phones.set(k, right.get(j));
            j++;
            k++;
        }
    }
}
