public class Invoker {
    private Command command;
    private CommandHistory history = new CommandHistory();

    public Invoker(CommandHistory history) {
        this.history = history;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
        history.push(command);
    }

    public void undoCommand() {
        if (!history.isEmpty()) {
            Command undoCommand = history.pop();
            undoCommand.undo();
        }
    }
}
