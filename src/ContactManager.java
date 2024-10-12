import java.util.List; // Importing the List interface

/**
 * The ContactManager class handles the operations related to contacts.
 */
public class ContactManager {
    private ContactList contactList; // List to manage contacts

    public ContactManager() {
        this.contactList = new ContactList(); // Initialize the ContactList
    }

    /**
     * Adds a contact to the manager.
     *
     * @param contact The contact to be added
     */
    public void addContact(Contact contact) {
        contactList.add(contact);
    }

    /**
     * Searches for a contact by name.
     *
     * @param name The name of the contact to search for
     * @return The found contact, or null if not found
     */
    public Contact searchContact(String name) {
        return contactList.find(name);
    }

    /**
     * Deletes a contact by name.
     *
     * @param name The name of the contact to be deleted
     */
    public void deleteContact(String name) {
        contactList.remove(name);
    }

    /**
     * Updates a contact's information.
     *
     * @param name       The name of the contact to update
     * @param newContact The new contact information
     */
    public void updateContact(String name, Contact newContact) {
        contactList.update(name, newContact);
    }

    /**
     * Displays all contacts in the list.
     */
    public void displayContacts() {
        contactList.getAllContacts().forEach(System.out::println);
    }

    /**
     * Returns a list of all contacts.
     *
     * @return A list of all contacts
     */
    public List<Contact> getAllContacts() {
        return contactList.getAllContacts();
    }
}
