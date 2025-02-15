public class Main {
    public static void main(String[] args) {
        System.out.println("------ Text -----");

        ContactsStorageInterface store = new ContactsStorageText("contacts.txt");

        ContactsManager manager = new ContactsManager(store);
        manager.openAndLoad(store);

        System.out.println(manager.toString());

        manager.add(new Contact("Jorge", 919191919));
        manager.add(new Contact("João", 929292929));

        System.out.println(manager.toString());

        manager.remove(manager.getByName("Maria"));
        System.out.println(manager.exist(manager.getByName("João")));

        System.out.println(manager.toString());
        manager.saveAndClose();

        System.out.println("------ Binary -----");
        ContactsStorageInterface store2 = new ContactsStorageBin("contacts.bin");

        ContactsManager manager2 = new ContactsManager(store2);
        manager2.openAndLoad(store2);

        System.out.println(manager2.toString());

        manager2.add(new Contact("Jorge", 919191919));
        manager2.add(new Contact("João", 929292929));

        System.out.println(manager2.toString());

        manager2.remove(manager2.getByName("Maria"));
        System.out.println(manager2.exist(manager2.getByName("João")));

        System.out.println(manager2.toString());
        manager2.saveAndClose();

    }
}
