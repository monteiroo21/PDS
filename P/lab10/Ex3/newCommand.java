import java.util.Collection;

public class newCommand<E> implements Command {
    private Collection<E> collection;
    private E element;

    public newCommand(Collection<E> collection, E element) {
        this.collection = collection;
        this.element = element;
    }

    public void execute() {
        collection.add(element);
    }

    public void undo() {
        collection.remove(element);
    }
}
