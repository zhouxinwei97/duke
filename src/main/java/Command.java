


public abstract class Command {

    protected String response;
    protected boolean isExit = false;

    public Command(String response) {

        this.response = response;

    }

    public abstract void execute(Storage tasksStorage, TaskList taskList, Ui ui) throws DukeException;

    public void printFormatting() {
        System.out.println("     ____________________________________________________________");
    }

    public boolean isExit() {
        return isExit;
    }
}