import javax.swing.DefaultListModel;

/**
 * The Sorter class provides methods to sort contacts based on different criteria.
 */
public class Sorter {
    // Sort contacts by name using bubble sort
    public void sortByName(DefaultListModel<Contact> model) {
        bubbleSort(model, "name"); // Call bubble sort with "name" criteria
    }

    // Sort contacts by phone using bubble sort
    public void sortByPhone(DefaultListModel<Contact> model) {
        bubbleSort(model, "phone"); // Call bubble sort with "phone" criteria
    }

    // Bubble sort implementation for sorting contacts
    private void bubbleSort(DefaultListModel<Contact> model, String criteria) {
        int n = model.getSize(); // Get the size of the model
        boolean swapped; // Flag to track if a swap occurred

        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Reset the swap flag for each iteration
            for (int j = 0; j < n - 1 - i; j++) {
                Contact c1 = model.get(j); // Get the first contact
                Contact c2 = model.get(j + 1); // Get the second contact
                boolean condition = criteria.equals("name")
                        ? c1.getName().compareToIgnoreCase(c2.getName()) > 0
                        : c1.getPhone().compareTo(c2.getPhone()) > 0; // Determine if a swap is needed

                if (condition) {
                    model.set(j, c2); // Swap the contacts
                    model.set(j + 1, c1); // Swap the contacts
                    swapped = true; // Set the swap flag
                }
            }
            if (!swapped) break; // Exit if no swaps occurred
        }
    }
}
