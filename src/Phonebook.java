import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

/**
 * The Phonebook class represents a graphical user interface for managing contacts.
 * It allows users to add, update, delete, search, and sort contacts.
 */
public class Phonebook extends JFrame {
    private DefaultListModel<Contact> contactListModel; // Model for the JList of contacts
    private JList<Contact> contactJList; // JList to display contacts
    private JTextField searchField; // Text field for search input
    private JButton addButton, updateButton, deleteButton, saveButton, sortByNameButton, sortByPhoneButton;
    private ContactManager contactManager; // Instance of ContactManager
    private Sorter sorter; // Instance of Sorter

    public Phonebook() {
        setTitle("Phonebook Application");
        setSize(340, 400); // Adjusted size to show buttons without full screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Center the JFrame on the screen
        setLocationRelativeTo(null);

        // Initialize the contact list model and JList
        contactListModel = new DefaultListModel<>();
        contactJList = new JList<>(contactListModel);
        JScrollPane scrollPane = new JScrollPane(contactJList);

        // Create input panel for search and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        // Search input field
        searchField = new JTextField();
        searchField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        searchField.setBorder(BorderFactory.createTitledBorder("Search Contacts"));
        inputPanel.add(searchField);

        // Buttons for contact management
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 5, 5)); // Changed to GridLayout for better button arrangement

        // Initialize buttons with background and foreground colors
        addButton = new JButton("Add Contact");
        addButton.setBackground(new Color(56, 163, 165));
        addButton.setForeground(Color.WHITE);

        updateButton = new JButton("Update Contact");
        updateButton.setBackground(new Color(56, 163, 165));
        updateButton.setForeground(Color.WHITE);
        updateButton.setEnabled(false);

        deleteButton = new JButton("Delete Contact");
        deleteButton.setBackground(new Color(56, 163, 165));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setEnabled(false);

        saveButton = new JButton("Save Contacts");
        saveButton.setBackground(new Color(56, 163, 165));
        saveButton.setForeground(Color.WHITE);

        sortByNameButton = new JButton("Sort by Name");
        sortByNameButton.setBackground(new Color(56, 163, 165));
        sortByNameButton.setForeground(Color.WHITE);

        sortByPhoneButton = new JButton("Sort by Phone");
        sortByPhoneButton.setBackground(new Color(56, 163, 165));
        sortByPhoneButton.setForeground(Color.WHITE);

        // Add buttons to the panel
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(sortByNameButton);
        buttonPanel.add(sortByPhoneButton);

        // Add components to the main frame
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Initialize ContactManager and Sorter
        contactManager = new ContactManager(contactListModel); // Pass model to ContactManager
        sorter = new Sorter(); // Initialize Sorter

        // Set up button actions
        addButton.addActionListener(e -> addContact());
        updateButton.addActionListener(e -> updateContact());
        deleteButton.addActionListener(e -> deleteContact());
        saveButton.addActionListener(e -> saveContacts());
        sortByNameButton.addActionListener(e -> sortContactsByName());
        sortByPhoneButton.addActionListener(e -> sortContactsByPhone());

        // Add search functionality
        searchField.addActionListener(e -> searchContacts());

        contactJList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                updateButton.setEnabled(contactJList.getSelectedValue() != null);
                deleteButton.setEnabled(contactJList.getSelectedValue() != null);
            }
        });

        // Load contacts from the file on startup
        loadContacts(); // Call to load contacts from the text file
    }

    private void loadContacts() {
        // Load contacts from a text file
        try (Scanner scanner = new Scanner(new File("contacts.txt"))) {
            contactListModel.clear(); // Clear existing contacts
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(","); // Expecting comma-separated name and phone
                if (parts.length == 2) {
                    contactListModel.addElement(new Contact(parts[0], parts[1])); // Add contact
                }
            }
            JOptionPane.showMessageDialog(this, "Contacts loaded successfully."); // Success message
        } catch (FileNotFoundException e) {
            showAlert("Error", "Contacts file not found."); // Error message
        }
    }

    private void saveContacts() {
        // Save contacts to a text file
        try (PrintWriter writer = new PrintWriter(new File("contacts.txt"))) {
            for (int i = 0; i < contactListModel.getSize(); i++) {
                Contact contact = contactListModel.get(i);
                writer.println(contact.getName() + "," + contact.getPhone()); // Write name and phone separated by a comma
            }
            JOptionPane.showMessageDialog(this, "Contacts saved successfully."); // Success message
        } catch (FileNotFoundException e) {
            showAlert("Error", "Unable to save contacts."); // Error message
        }
    }

    private void addContact() {
        String name = JOptionPane.showInputDialog(this, "Enter contact name:"); // Prompt for name
        if (name != null && !name.trim().isEmpty()) { // Check for valid input
            String phone = JOptionPane.showInputDialog(this, "Enter contact phone:"); // Prompt for phone
            if (phone != null && !phone.trim().isEmpty()) { // Check for valid input
                contactManager.addContact(name, phone); // Add contact using ContactManager
            } else {
                showAlert("Invalid Input", "Phone cannot be empty."); // Show alert for empty phone
            }
        } else {
            showAlert("Invalid Input", "Name cannot be empty."); // Show alert for empty name
        }
    }

    private void deleteContact() {
        Contact selectedContact = contactJList.getSelectedValue(); // Get selected contact
        if (selectedContact != null) {
            int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this contact?", "Delete Contact", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                contactManager.deleteContact(selectedContact); // Remove contact using ContactManager
            }
        }
    }

    private void updateContact() {
        Contact selectedContact = contactJList.getSelectedValue(); // Get selected contact
        if (selectedContact != null) {
            String newName = JOptionPane.showInputDialog(this, "Update Name:", selectedContact.getName()); // Prompt for new name
            String newPhone = JOptionPane.showInputDialog(this, "Update Phone:", selectedContact.getPhone()); // Prompt for new phone
            if (newName != null && !newName.trim().isEmpty() && newPhone != null && !newPhone.trim().isEmpty()) {
                contactManager.updateContact(selectedContact, newName, newPhone); // Update contact using ContactManager
                contactJList.repaint(); // Refresh the JList
            } else {
                showAlert("Invalid Input", "Name and Phone cannot be empty."); // Show alert for invalid input
            }
        }
    }

    private void searchContacts() {
        String searchTerm = searchField.getText(); // Get search term
        DefaultListModel<Contact> filteredModel = contactManager.searchContacts(searchTerm); // Use ContactManager to search
        contactJList.setModel(filteredModel); // Update the JList with the filtered contacts
    }

    private void sortContactsByName() {
        sorter.sortByName(contactListModel); // Use Sorter to sort by name
        contactJList.repaint(); // Refresh the JList
    }

    private void sortContactsByPhone() {
        sorter.sortByPhone(contactListModel); // Use Sorter to sort by phone
        contactJList.repaint(); // Refresh the JList
    }

    private void showAlert(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE); // Show alert dialog
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Phonebook phonebook = new Phonebook(); // Create an instance of Phonebook
            phonebook.setVisible(true); // Set the frame visible
        });
    }
}
