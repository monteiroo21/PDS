import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextReader implements FilterInterface {
    private String filename;
    private Scanner sc;

    public TextReader(String filename) throws FileNotFoundException {
        this.filename = filename;
        sc = new Scanner(new File(filename));
    }

    public boolean hasNext() {
        return sc.hasNextLine();
    }

    public String next() {
        return sc.nextLine();
    }
}
