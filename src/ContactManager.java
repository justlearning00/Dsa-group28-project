import javax.swing.DefaultListModel;

/**
 * The ContactManager class is responsible for managing the contacts.
 * It provides methods for adding, deleting, updating, and searching contacts.
 */
public class ContactManager {
    private DefaultListModel<Contact> contactListModel; // Model to hold contacts

    public ContactManager(DefaultListModel<Contact> contactListModel) {
        this.contactListModel = contactListModel; // Initialize the contact list model
    }

    // Add a new contact to the list
    public void addContact(String name, String phone) {
        // Check for duplicate contacts
        for (int i = 0; i < contactListModel.getSize(); i++) {
            if (contactListModel.get(i).getName().equalsIgnoreCase(name)) {
                return; // Exit if a duplicate is found
            }
        }
        contactListModel.addElement(new Contact(name, phone)); // Add the new contact
    }

    // Delete the specified contact
    public void deleteContact(Contact contact) {
        contactListModel.removeElement(contact); // Remove the contact from the model
    }

    // Update the specified contact's details
    public void updateContact(Contact contact, String newName, String newPhone) {
        contact.setName(newName); // Update the name
        contact.setPhone(newPhone); // Update the phone number
    }

    // Search contacts using a linear search algorithm
    public DefaultListModel<Contact> searchContacts(String searchTerm) {
        DefaultListModel<Contact> filteredModel = new DefaultListModel<>(); // Create a new model for filtered contacts

        // Perform a linear search for matching contacts
        for (int i = 0; i < contactListModel.getSize(); i++) {
            Contact contact = contactListModel.get(i); // Get contact
            // Check if the name or phone contains the search term
            if (contact.getName().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    contact.getPhone().contains(searchTerm)) {
                filteredModel.addElement(contact); // Add to filtered model if match found
            }
        }
        return filteredModel; // Return the filtered contacts
    }
}
