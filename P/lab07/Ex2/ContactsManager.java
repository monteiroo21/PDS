import java.util.ArrayList;
import java.util.List;

public class ContactsManager implements ContactsInterface {
    private ContactsStorageInterface store;
    private List<Contact> contacts = new ArrayList<>();

    public ContactsManager(ContactsStorageInterface store) {
        this.store = store;
    }

    @Override
    public void openAndLoad(ContactsStorageInterface store) {
        this.contacts.addAll(store.loadContacts());
    }

    @Override
    public void saveAndClose() {
        this.store.saveContacts(this.contacts);
    }

    @Override
    public void saveAndClose(ContactsStorageInterface store) {
        store.saveContacts(this.contacts);
    }

    @Override
    public boolean exist(Contact contact) {
        if (this.contacts.contains(contact)) {
            return true;
        }
        return false;
    }

    @Override
    public Contact getByName(String name) {
        for (Contact contact : this.contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    @Override
    public boolean add(Contact contact) {
        if (!this.contacts.contains(contact)) {
            this.contacts.add(contact);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Contact contact) {
        if (this.contacts.contains(contact)) {
            this.contacts.remove(contact);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Contact contact : contacts) {
            sb.append(contact.getName() + " - " + contact.getNumber() + "\n");
        }
        return sb.toString();
    }

}
