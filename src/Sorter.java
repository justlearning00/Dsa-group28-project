import java.util.List;

/**
 * The Sorter class provides sorting methods for contacts using simple sorting algorithms.
 */
public class Sorter {

    /**
     * Sorts the list of contacts by name using Bubble Sort algorithm.
     *
     * @param contacts The list of contacts to be sorted
     */
    public static void sortByName(List<Contact> contacts) {
        int n = contacts.size(); // Get the number of contacts
        // Bubble Sort algorithm
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (contacts.get(j).getName().compareToIgnoreCase(contacts.get(j + 1).getName()) > 0) {
                    // Swap contacts if they are in the wrong order
                    Contact temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Sorts the list of contacts by phone number using Bubble Sort algorithm.
     *
     * @param contacts The list of contacts to be sorted
     */
    public static void sortByPhone(List<Contact> contacts) {
        int n = contacts.size(); // Get the number of contacts
        // Bubble Sort algorithm
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (contacts.get(j).getPhone().compareTo(contacts.get(j + 1).getPhone()) > 0) {
                    // Swap contacts if they are in the wrong order
                    Contact temp = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, temp);
                }
            }
        }
    }
}

