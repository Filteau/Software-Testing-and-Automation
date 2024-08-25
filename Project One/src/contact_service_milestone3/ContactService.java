package contact_service_milestone3;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // In-memory storage for contacts
    private final Map<String, Contact> contacts;

    // Constructor for initializing contact service
    public ContactService() {
        contacts = new HashMap<>();
    }

    // Method to add a new contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists");
            
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Method to delete a contact by ID
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactID);
    }

    // Method to update the first name of a contact by ID
    public void updateContactFirstName(String contactId, String firstName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setFirstName(firstName);
    }

    // Method to update the last name of a contact by ID
    public void updateContactLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setLastName(lastName);
    }

    // Method to update the phone number of a contact by ID
    public void updateContactPhone(String contactId, String phone) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        contact.setPhone(phone);
    }

    // Method to update the address of a contact by ID
    public void updateContactAddress(String contactId, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setAddress(address);
    }

    // Method to retrieve a contact by ID
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
