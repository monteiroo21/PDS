import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MobilePhone> phones = new ArrayList<>();
        phones.add(new MobilePhone("ProcessorA", 500.0, 8, 12, "Samsung"));
        phones.add(new MobilePhone("ProcessorB", 300.0, 4, 8, "Xiaomi"));
        phones.add(new MobilePhone("ProcessorC", 700.0, 6, 16, "Apple"));

        // Usar BubbleSort
        MobilePhoneSorter sorter = new MobilePhoneSorter(new BubbleSort());
        sorter.sort(phones, Comparator.comparing(MobilePhone::getPrice));
        System.out.println("Ordenado por preço (BubbleSort):");
        phones.forEach(System.out::println);

        // Usar QuickSort
        sorter = new MobilePhoneSorter(new QuickSort());
        sorter.sort(phones, Comparator.comparing(MobilePhone::getMemory));
        System.out.println("Ordenado por memória (QuickSort):");
        phones.forEach(System.out::println);

        // Usar MergeSort
        sorter = new MobilePhoneSorter(new MergeSort());
        sorter.sort(phones, Comparator.comparing(MobilePhone::getCamera));
        System.out.println("Ordenado por câmara (MergeSort):");
        phones.forEach(System.out::println);
    }
}
