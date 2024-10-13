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

1. ContactManager Class

Purpose: Manages the core contact operations such as adding, deleting, updating, and searching contacts.

Functions:
- addContact(String name, String phone): Adds a new contact if it doesn't already exist.
- deleteContact(Contact contact): Removes a contact from the list.
- updateContact(Contact contact, String newName, String newPhone): Updates the details of an existing contact.
- searchContacts(String searchTerm): Searches the contact list for entries matching the search term.

2. Sorter Class

Purpose: Handles the sorting of contacts based on either name or phone number.

Functions:
- sortByName(DefaultListModel<Contact> contactListModel): Sorts the contacts alphabetically by name.
- sortByPhone(DefaultListModel<Contact> contactListModel): Sorts the contacts numerically by phone number.

3. Contact Class

Purpose: Represents a single contact with its name and phone number.

Attributes:
- String name: The contact's name.
- String phone: The contact's phone number.

Functions:
- getName(): Returns the contact's name.
- setName(String name): Sets the contact's name.
- getPhone(): Returns the contact's phone number.
- setPhone(String phone): Sets the contact's phone number.

4. Phonebook Class

Purpose: The main graphical user interface (GUI) for the application, which enables users to interact with contacts.

Functions:
- loadContacts(): Loads contacts from a text file when the application starts.
- saveContacts(): Saves the current contacts to a text file.
- addContact(): Prompts the user to add a new contact.
- deleteContact(): Allows the user to delete a selected contact.
- updateContact(): Enables the user to update an existing contact's details.
- searchContacts(): Filters the displayed contacts based on a search term.
- sortContactsByName(): Sorts the contacts by name using the Sorter class.
- sortContactsByPhone(): Sorts the contacts by phone number using the Sorter class.
- showAlert(String title, String message): Displays error or alert messages to the user.

GUI Components:
- Buttons (addButton, updateButton, deleteButton, etc.) for contact operations.
- JList for displaying the list of contacts.
- JTextField for search functionality.


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
│		              	ContactManager.java
│				             Sorter.java
│	
│	
contacts.txt


 
