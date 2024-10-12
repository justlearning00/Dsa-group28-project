import java.util.ArrayList;
import java.util.List;

/**
 * The ContactList class manages a list of contacts using a linear data structure (ArrayList).
 */
public class ContactList {
    private List<Contact> contacts; // List to hold contacts

    public ContactList() {
        contacts = new ArrayList<>(); // Initialize the list
    }

    /**
     * Adds a new contact to the list.
     *
     * @param contact The contact to be added
     */
    public void add(Contact contact) {
        contacts.add(contact);
    }

    /**
     * Searches for a contact by name.
     *
     * @param name The name of the contact to search for
     * @return The found contact, or null if not found
     */
    public Contact find(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact; // Return found contact
            }
        }
        return null; // Return null if not found
    }

    /**
     * Removes a contact from the list by name.
     *
     * @param name The name of the contact to be removed
     */
    public void remove(String name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
    }

    /**
     * Updates a contact in the list by name.
     *
     * @param name       The name of the contact to update
     * @param newContact The new contact information
     */
    public void update(String name, Contact newContact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                contacts.set(i, newContact); // Update the contact
                break;
            }
        }
    }

    /**
     * Returns a list of all contacts.
     *
     * @return A list containing all contacts
     */
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts); // Return a copy of the list
    }
}
