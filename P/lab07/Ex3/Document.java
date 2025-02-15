import java.util.Scanner;
import java.io.File;

public class Document {
    private String document;

    public Document(String document) {
        this.document = document;
    }

    public String getDocument() {
        return this.document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String readFile() {
        StringBuilder text = new StringBuilder();
        try {
            File file = new File(document);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {  
                text.append(sc.nextLine());
            }
            sc.close();
            return text.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
