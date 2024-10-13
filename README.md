# Dsa-group28-project
Phonebook

 Phonebook Application Documentation
 
 Contibutors
 
        TL -Alicia Sasamba      224081772
           Khitago Langerman	  22066722
           Ravi Ngongo	        224009443
           Pj-Amor Harakuta	    224063596
           Tjimezeri Tjihozu    223127418

Project Description:
The Phonebook Application is a simple Java-based GUI application that allows users to manage their contacts efficiently. Users can add, update, delete, search, and sort contacts. The application uses a text file to store contact information, making it easy to load and save data.

Features:
- Add new contacts
- Update existing contacts
- Delete contacts
- Search for contacts by name or phone number
- Sort contacts by name or phone number
- Load and save contacts from/to a text file

Modules And Functions Descriptions

1. Contact Class
- Purpose: Represents a single contact in the phonebook.
- Attributes:
  - name: The name of the contact.
  - phone: The phone number of the contact.
- Functions:
  - Constructor: Initializes a new Contact object with a name and phone number.
  - Getters and Setters: Methods to access and modify the contact's name and phone number.
  - toString(): Returns a string representation of the contact in the format "name - phone".


 3.ContactManager Class
- Purpose: Acts as a mediator between the Phonebook GUI and the ContactList, managing contact operations.
- Attribute:
  - contactList: An instance of ContactList that holds the contacts.
- Functions:
  - addContact(Contact contact): Adds a contact to the contact list.
  - searchContact(String name): Searches for a contact by name.
  - deleteContact(String name): Deletes a contact by name.
  - updateContact(String name, Contact newContact): Updates a contact's information.
  - displayContacts(): Displays all contacts in the list.
  - getAllContacts(): Returns a list of all contacts.

4. Phonebook Class (GUI)
- Purpose: Provides a graphical user interface for managing contacts. Handles user interactions and displays the contact list.
- Attributes:
  - contactListModel: A model for the JList that displays contacts.
  - contactJList: A JList component to show the list of contacts.
  - searchField: A text field for user input to search contacts.
  - addButton, updateButton, deleteButton, saveButton, sortByNameButton, sortByPhoneButton: Buttons for performing various operations.
- Functions:
  - Constructor: Initializes the GUI components and sets up action listeners.
  - loadContacts(): Loads contacts from a file when the application starts.
  - saveContacts(): Saves the current list of contacts to a file.
  - addContact(): Handles adding a new contact through user input.
  - deleteContact(): Handles deletion of the selected contact.
  - updateContact(): Handles updating the selected contact's information.
  - searchContacts(): Filters contacts in the list based on the search input using a linear search algorithm.
  - sortContactsByName(): Sorts contacts by name and refreshes the display.
  - sortContactsByPhone(): Sorts contacts by phone number and refreshes the display.
  - bubbleSort(DefaultListModel<Contact> model, String sortBy): Implements the bubble sort algorithm for sorting contacts.
  - showAlert(String title, String message): Displays alert messages to the user.
  - main(String[] args): The entry point for the application, creating and displaying the Phonebook GUI.

 5. Sorter Module
- Purpose: Provides sorting functionality for the list of contacts, allowing users to organize contacts either by name or phone number.
- Functions:
  - sortByName(ContactList contactList): Sorts the contacts in the given ContactList by the contact names. This is implemented using a bubble sort  algorithm.
  - sortByPhone(ContactList contactList): Sorts the contacts in the given ContactList by phone numbers, using a sbubble sort algorithm.
  
 -Integration with Other Modules
  - The Phonebook class would call the sorting methods from this module when the user selects the option to sort contacts.
  - The ContactList would provide access to its contacts, allowing the sorter to manipulate the list as needed.



Usage
1. Prerequisites
   - Java Development Kit (JDK) version 8 or higher installed on your machine.
  - Intelli J idea IDE (IDE WE USED).


3. Application Functionality:
   - To add a contact, click on "Add Contact" and fill in the name and phone number.
   - Use the search field to find contacts by entering part of their name or phone number.
   - Click "Sort by Name" or "Sort by Phone" to sort contacts accordingly.
   - Select a contact to update or delete , as the two buttons will only appear then and confirm your action.

 File Structure should look like this

Dsa/
├src/
│               Contact.java
│               Phonebook.java
│                ContactList.java
│		              	ContactManager.java
│				             Sorter.java
│	
│	
contacts.txt


 
