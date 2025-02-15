import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ContactsStorageText implements ContactsStorageInterface {
    private String file;

    public ContactsStorageText(String file) {
        this.file = file;
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get(file));
            for (String ln : lines) {
                String[] contact = ln.split(" - ");

                if (contact.length != 2) {
                    System.err.println("Invalid line: " + ln);
                    continue;
                }

                try {
                    int n = Integer.parseInt(contact[1]);
                    Contact c = new Contact(contact[0], n);
                    contacts.add(c);
                } catch (Exception e) {
                    System.err.println("Invalid number: " + contact[1]);
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }

        return contacts;
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try {
            File f = new File("savedContactsText.txt");
            FileWriter fileWriter = new FileWriter(f);

            for (Contact contact : list) {
                fileWriter.write(contact.getName() + " - " + contact.getNumber() + "\n");
            }
            fileWriter.close();

            return true;
        } catch (Exception e) {
            System.err.println("Error: " + e);
            System.exit(1);
        }
        return false;
    }

}
