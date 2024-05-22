import java.util.*;

class Contact {
    String name;
    String phoneNumber;
    String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

public class ContactManager {

    static ArrayList<Contact> contactList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add a new contact");
            System.out.println("2. View contact list");
            System.out.println("3. Edit a contact");
            System.out.println("4. Delete a contact");
            System.out.println("5. Exit");

            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter the email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contactList.add(contact);

        System.out.println("Contact added successfully.");
    }

    private static void viewContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts to display.");
            return;
        }

        System.out.println("Contact List: ");
        for (Contact contact : contactList) {
            System.out.println(contact);
        }
    }

    private static void editContact() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts to edit.");
            return;
        }

        System.out.println("Enter the index of the contact to edit: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        if (index >= 0 && index < contactList.size()) {
            System.out.println("Enter the new name: ");
            String name = scanner.nextLine();
            System.out.println("Enter the new phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.println("Enter the new email: ");
            String email = scanner.nextLine();

            Contact contact = new Contact(name, phoneNumber, email);
            contactList.set(index, contact);

            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    private static void deleteContact() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts to delete.");
            return;
        }

        System.out.println("Enter the index of the contact to delete: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();

        if (index >= 0 && index < contactList.size()) {
            contactList.remove(index);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }
} 