import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FilterInterface reader = new TextReader("sentence.txt");
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
        System.out.println();
        reader = new NormalizationFilter(new TextReader("sentence.txt"));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
        System.out.println();
        reader = new VowelFilter(new TermFilter(new TextReader("sentence.txt")));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
        System.out.println();
        reader = new CapitalizationFilter(new TextReader("sentence.txt"));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
        System.out.println();
        reader = new TermFilter(new TextReader("sentence.txt"));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
    }
}
