import java.util.Iterator;
import java.util.ListIterator;

public interface InterfaceVectorGen<T> {
    public boolean addElem(T elem);

    public boolean removeElem(T elem);

    public int totalElem();

    public T getElem(int i);

    public Iterator<T> iterator();

    public ListIterator<T> listIterator();

    public ListIterator<T> listIterator(int index);
}
