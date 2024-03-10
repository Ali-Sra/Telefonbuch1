public class ContactManager {
    private Contact[] contacts;
    private int counter;

    public ContactManager() {
        counter = 0;
        contacts = new Contact[1000];
    }

    public boolean addContact(Contact contact) {
        if (counter < contacts.length) {
            contacts[counter] = new Contact(contact.getName(), contact.getNumber());
            contacts[counter].setEmail(contact.getEmail());
            contacts[counter].setAddress(contact.getAddress());
            counter++;
            return true;
        } else {
            return false;
        }
    }

    public Contact[] searchContactByName(String name) {
        Contact[] contacts1 = new Contact[1000];
        int cnt = 0;
        for (Contact contact : contacts) {
            if (contact != null && contact.getName().contains(name)) {
                contacts1[cnt] = new Contact(contact.getName(), contact.getNumber());
                contacts1[cnt].setEmail(contact.getEmail());
                contacts1[cnt].setAddress(contact.getAddress());
                cnt++;
            }
        }
        return contacts1;
    }

    public Contact[] searchContactByNumber(String number) {
        Contact[] contacts1 = new Contact[1000];
        int cnt = 0;
        for (Contact contact : contacts) {
            if (contact != null && contact.getNumber().contains(number)) {
                contacts1[cnt] = new Contact(contact.getName(), contact.getNumber());
                contacts1[cnt].setEmail(contact.getEmail());
                contacts1[cnt].setAddress(contact.getAddress());
                cnt++;
            }
        }
        return contacts1;
    }

    public boolean editContact(Contact contact, int index) {
        if (index < 0 || index >= counter) {
            System.out.println("Invalid index");
            return false;
        } else {
            contacts[index].setName(contact.getName());
            contacts[index].setNumber(contact.getNumber());
            contacts[index].setEmail(contact.getEmail());
            contacts[index].setAddress(contact.getAddress());
            return true;
        }
    }

    public int getContactIndexByName(String name) {
        for (int i = 0; i < counter; i++) {
            if (contacts[i] != null && contacts[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean deleteContact(int index) {
        if (index < 0 || index >= counter)
            return false;

        for (int i = index; i < counter - 1; i++) {
            contacts[i] = contacts[i + 1];
        }
        contacts[counter - 1] = null;
        counter--;
        return true;
    }

    public Contact[] getContacts() {
        Contact[] result = new Contact[counter];
        System.arraycopy(contacts, 0, result, 0, counter);
        return result;



    }
}
