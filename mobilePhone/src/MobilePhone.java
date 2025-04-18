import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> contacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<>();
    }

    public MobilePhone() {
        this.myNumber = "";
        this.contacts = new ArrayList<>();
    }

    public int findContact(Contact contact) {
        for (int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getName().equalsIgnoreCase(contact.getName())) {
                return i;
            }
        }
        return -1;
    }

    private int findContact(String name) {
        for(int i = 0; i < contacts.size(); i++) {
            if(contacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addContact(Contact contact) {
       if(findContact(contact.getName()) >= 0) {
           System.out.println("Contact Already Exists.");
           return false;
       } else {
           contacts.add(contact);
           System.out.println("Contact Added.");
           return true;
       }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundContact = findContact(oldContact.getName());

        if(foundContact >= 0) {
            contacts.set(foundContact, newContact);
            System.out.println("Contact updated.");
            return true;
        } else {
            System.out.println("Contact not found.");
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        int foundContact = findContact(contact.getName());

        if (foundContact >= 0) {
            contacts.remove(foundContact);
            System.out.println("Contact removed.");
            return true;
        } else {
            System.out.println("Contact not found.");
            return false;
        }
    }

    public Contact queryContact(String name) {
        int foundContact = findContact(name);

        if (foundContact >= 0) {
            System.out.println("Contact found.");
            return contacts.get(foundContact);
        } else {
            System.out.println("Contact not found.");
            return null;
        }
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for(int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i).getName() + " -> " + contacts.get(i).getPhoneNumber());
        }
    }

}
