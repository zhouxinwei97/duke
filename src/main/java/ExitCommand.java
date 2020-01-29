

public class ExitCommand extends Command {

    public ExitCommand(String response) {

        super(response);

    }

    public void execute(Storage tasksStorage, TaskList taskList, Ui ui) throws DukeException {

        this.isExit = true;
        System.out.println("     Bye. Hope to see you again soon!");
        tasksStorage.storeToStorage(taskList.getList());

    }
}
