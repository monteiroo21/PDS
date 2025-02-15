import java.util.ArrayList;
import java.util.Collection;

public class Ex3Main {
    public static void main(String[] args) {
        CommandHistory history = new CommandHistory();
        Invoker invoker = new Invoker(history);
        Collection<String> collection = new ArrayList<>();

        Command addCommand = new newCommand<>(collection, "Hello");
        Command removeCommand = new removeCommand<>(collection, "Hello");

        invoker.setCommand(addCommand);
        invoker.executeCommand();
        System.out.println(collection);

        invoker.setCommand(removeCommand);
        invoker.executeCommand();
        System.out.println(collection);

        invoker.undoCommand();
        System.out.println(collection);

        Command addCommand2 = new newCommand<>(collection, "World");
        Command addCommand3 = new newCommand<>(collection, "Hello");

        invoker.setCommand(addCommand2);
        invoker.executeCommand();
        invoker.setCommand(addCommand3);
        invoker.executeCommand();

        System.out.println(collection);

        invoker.undoCommand();
        System.out.println(collection);

        invoker.undoCommand();
        System.out.println(collection);

    }
}
