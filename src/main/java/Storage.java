import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Storage to store and retrieve all data that is stored in the hard disk.
 */
public class Storage {
    
    Path path;

    /**
     * Creates an instance of Storage object with the path to the file.
     */
    public Storage() {

        this.path = Paths.get("data", "duke.txt");

    }

    /**
     * Method invoked to retrieve all information from storage to the program.
     * @return an ArrayList of tasks that was stored in the hard disk.
     */
    public ArrayList<String> startupStorage() throws DukeException {

        try {
            return readFile(this.path);
        } catch (IOException e) {
            File file = new File("data");
            if (!file.exists()) {
                new File("data").mkdir();
            }
            try {
                new File("data/duke.txt").createNewFile();
            } catch (IOException ex) {
                throw new DukeException(ex.getMessage());
            }

            return new ArrayList<String>();
        }


    }

    /**
     * Stores the tasks in the program to the hard disk.
     * @param list the list that stores all the tasks.
     */
    public void storeToStorage(ArrayList<Task> list) {

        try {
            writeToHardDisk(list);
        } catch (IOException e) {
            File newFile = new File("./data/duke.txt");
            System.out.println("File created");
        }
    }


    /**
     * Read the file line by line to retrieve data from the hard disk.
     * @param filepath the path where the file is stored.
     * @return an ArrayList of tasks that is retrieved from the hard disk.
     * @throws IOException if file is not found in the file path.
     */
    private ArrayList<String> readFile(Path filepath) throws IOException {
        File f = filepath.toFile();
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        ArrayList<String> mylist = new ArrayList<>();
        while (s.hasNext()) {
            String tasks = s.nextLine();
            mylist.add(tasks);
        }

        return mylist;

    }


    /**
     * Writes the information from the program into the hard disk file.
     * @param list task list that is to be stored.
     * @throws IOException if file is not found in the file path.
     */
    private void writeToHardDisk(ArrayList<Task> list) throws IOException {
        File f = this.path.toFile();
        FileWriter writer = new FileWriter(f);

        for (Task tasks : list) {
            writer.write(tasks.saveToHardDiskFormat() + System.lineSeparator());
        }
        writer.close();

    }
}
