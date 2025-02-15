import java.util.Iterator;

public class VectorIterator<T> implements Iterator<T> {
    private VectorGeneric<T> vector;
    private int idx;

    public VectorIterator(VectorGeneric<T> vector) {
        this.vector = vector;
        idx = 0;
    }

    public boolean hasNext() {
        return idx < vector.totalElem();
    }

    @Override
    public T next() {
        return vector.getElem(idx++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
