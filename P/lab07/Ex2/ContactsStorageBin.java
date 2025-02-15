import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsStorageBin implements ContactsStorageInterface {
    private String file;

    public ContactsStorageBin(String file) {
        this.file = file;
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        try {
            FileInputStream f = new FileInputStream(new File(file));

            int ch;
            while ((ch = f.read()) != -1) {
                sb.append((char) ch);
            }

            f.close();
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            System.exit(1);
        }

        Scanner sc = new Scanner(sb.toString());

        while (sc.hasNextLine()) {
            String[] contact = sc.nextLine().split(" - ");
            String name = contact[0];
            int number = Integer.parseInt(contact[1]);
            Contact c = new Contact(name, number);
            contacts.add(c);
        }

        sc.close();

        return contacts;
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("savedContactsBin.bin"))) {
            for (Contact contact : list) {
                dos.writeUTF(contact.getName());
                dos.writeInt(contact.getNumber());
            }
            return true;
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e.getMessage());
            System.exit(1);
        }
        return false;
    }

}
