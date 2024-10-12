/**
 * The Contact class represents a contact in the phonebook application.
 * It contains the contact's name and phone number.
 */
public class Contact {
    private String name;  // The name of the contact
    private String phone; // The phone number of the contact

    /**
     * Constructor to initialize a new Contact with a name and phone number.
     *
     * @param name  The name of the contact
     * @param phone The phone number of the contact
     */
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns a string representation of the contact.
     *
     * @return A string in the format "name - phone"
     */
    @Override
    public String toString() {
        return name + " - " + phone; // Display format
    }
}
