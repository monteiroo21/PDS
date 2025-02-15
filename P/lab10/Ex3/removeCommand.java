import java.util.Collection;

public class removeCommand<E> implements Command {
    private Collection<E> collection;
    private E element;

    public removeCommand(Collection<E> collection, E element) {
        this.collection = collection;
        this.element = element;
    }

    public void execute() {
        collection.remove(element);
    }

    public void undo() {
        collection.add(element);
    }
}
