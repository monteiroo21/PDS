import java.util.ListIterator;

public class VectorListIterator<T> implements ListIterator<T> {
    private VectorGeneric<T> vector;
    private int idx;

    public VectorListIterator(VectorGeneric<T> vector) {
        this.vector = vector;
        idx = 0;
    }

    public VectorListIterator(VectorGeneric<T> vector, int idx) {
        this.vector = vector;
        if (idx < 0 || idx > vector.totalElem())
            throw new IndexOutOfBoundsException();
        this.idx = idx;
    }

    @Override
    public boolean hasNext() {
        return idx < vector.totalElem();
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new IndexOutOfBoundsException();
        return vector.getElem(idx++);
    }

    @Override
    public boolean hasPrevious() {
        return idx > 0;
    }

    @Override
    public T previous() {
        if (!hasPrevious())
            throw new IndexOutOfBoundsException();
        return vector.getElem(--idx);
    }

    @Override
    public int nextIndex() {
        return idx;
    }

    @Override
    public int previousIndex() {
        return idx - 1;
    }

    @Override
    public void remove() {
        if (idx == 0)
            throw new IllegalStateException();
        vector.removeElem(vector.getElem(--idx));
    }

    @Override
    public void set(T e) {
        if (idx == 0)
            throw new IllegalStateException();
        vector.getElem(idx - 1);
    }

    @Override
    public void add(T e) {
        vector.addElem(e);
    }
}
