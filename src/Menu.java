import java.util.Scanner;

public class Menu {
    private ContactManager contactManager;

    public Menu() {
        contactManager = new ContactManager();
    }

    public void showMenu() {
        Scanner s = new Scanner(System.in);
        int selectedOption = 0;
        while (selectedOption != 8) {
            System.out.println("---------------**************----------------\n");
            System.out.print("1. Show contacts\n2. Add new contact\n3. Search contact by name\n4. Search contact by number\n5. Get Contact Index By Name\n6. Edit contact\n7. Delete Contact\n8. Exit\n");
            System.out.println("---------------**************----------------");
            selectedOption = s.nextInt();
            proccessOption(selectedOption);
        }
    }

    public void proccessOption(int number) {
        Scanner s = new Scanner(System.in);
        switch (number) {
            case 1:
                Contact[] contacts = contactManager.getContacts();
                for (Contact contact : contacts) {
                    System.out.printf("Name:%s Number:%s email:%s address:%s\n", contact.getName(), contact.getNumber(), contact.getEmail(), contact.getAddress());
                }
                break;
            case 2:
                contactManager.addContact(getContactInfo());
                break;
            case 3:
                System.out.println("Enter name");
                String name = s.nextLine();
                Contact[] contacts1 = contactManager.searchContactByName(name);
                printContact(contacts1);
                break;
            case 4:
                System.out.println("Enter number");
                String number1 = s.nextLine();
                Contact[] contacts2 = contactManager.searchContactByNumber(number1);
                printContact(contacts2);
                break;
            case 5:
                System.out.println("Enter name");
                String name1 = s.nextLine();
                int index = contactManager.getContactIndexByName(name1);
                System.out.println(index);
                break;
            case 6:
                System.out.println("Enter index");
                int editIndex = s.nextInt();
                s.nextLine(); // Consume newline character
                Contact cntEdit = getContactInfo();
                contactManager.editContact(cntEdit, editIndex);
                break;
            case 7:
                System.out.println("Enter index");
                int deleteIndex = s.nextInt();
                contactManager.deleteContact(deleteIndex);
                break;
        }
    }

    private void printContact(Contact[] contacts) {
        for (Contact contact : contacts) {
            if (contact != null) {
                System.out.printf("Name:%s Number:%s email:%s address:%s\n", contact.getName(), contact.getNumber(), contact.getEmail(), contact.getAddress());
            }
        }
    }

    private Contact getContactInfo() {
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        System.out.println("Enter Name");
        contact.setName(scanner.nextLine());
        System.out.println("Enter Number");
        contact.setNumber(scanner.nextLine());
        System.out.println("Enter Email");
        contact.setEmail(scanner.nextLine());
        System.out.println("Enter Address");
        contact.setAddress(scanner.nextLine());
        return contact;
    }
}



