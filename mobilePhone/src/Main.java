//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Contact contact = new Contact("Nazar", "123415215");
        Contact contact1 = new Contact("Artur", "213132321");
        Contact contact2 = new Contact("Adrian", "3123123123");

        MobilePhone mobilePhone = new MobilePhone();
        MobilePhone mobilePhone1 = new MobilePhone();
        MobilePhone mobilePhone2 = new MobilePhone();

        mobilePhone.addContact(contact);
        mobilePhone.addContact(contact1);
        mobilePhone.addContact(contact2);

        mobilePhone.updateContact(contact, contact1);
        mobilePhone.removeContact(contact1);
        mobilePhone.queryContact("Adrian");

        mobilePhone.printContacts();
    }
}