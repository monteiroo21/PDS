import java.util.Iterator;
import java.util.ListIterator;

public class Ex1Main {
    public static void main(String[] args) {
        VectorGeneric<String> vg = new VectorGeneric<>();
        vg.addElem("um");
        vg.addElem("dois");
        vg.addElem("tres");
        vg.addElem("quatro");
        vg.addElem("cinco");
        System.out.println("vg: " + vg.toString());
        System.out.println("vg.totalElem(): " + vg.totalElem());

        VectorGeneric<Integer> vg2 = new VectorGeneric<>();
        vg2.addElem(1);
        vg2.addElem(2);
        vg2.addElem(3);
        vg2.addElem(4);
        vg2.removeElem(3);
        System.out.println("vg2: " + vg2.toString());
        System.out.println("vg2.totalElem(): " + vg2.totalElem());

        VectorGeneric<Double> vg3 = new VectorGeneric<>();
        vg3.addElem(1.0);
        vg3.addElem(2.0);
        vg3.addElem(3.0);
        vg3.addElem(4.0);
        vg3.addElem(5.0);
        ListIterator<Double> it = vg3.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        VectorGeneric<Integer> vg4 = new VectorGeneric<>();
        vg4.addElem(1);
        vg4.addElem(2);
        vg4.addElem(3);
        Iterator<Integer> it2 = vg4.iterator();
        ListIterator<Integer> it3 = vg4.listIterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
        while (it3.hasNext()) {
            System.out.println(it3.next());
        }
    }
}
