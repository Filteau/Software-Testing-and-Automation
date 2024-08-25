package contact_service_milestone3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService contactService;

    // Initializing contact service before each test
    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    // Test to verify adding a new contact
    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("1"));
    }

    // Test to verify adding duplicate contactID
    @Test
    public void testAddDuplicateContactID() {
        Contact contact1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1", "Jane", "Smith", "0987654321", "456 Elm St");
        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    // Test to verify deleting contact by ID
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1");
        assertNull(contactService.getContact("1"));
    }

    // Test to verify deleting a non-existent contact
    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("999");
        });
    }

    // Test to verify updating contact's first name
    @Test
    public void testUpdateContactFirstName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContactFirstName("1", "Jane");

        Contact updatedContact = contactService.getContact("1");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhone());
        assertEquals("123 Main St", updatedContact.getAddress());
    }

    // Test to verify updating contact's last name
    @Test
    public void testUpdateContactLastName() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContactLastName("1", "Smith");

        Contact updatedContact = contactService.getContact("1");
        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhone());
        assertEquals("123 Main St", updatedContact.getAddress());
    }

    // Test to verify updating contact's phone number
    @Test
    public void testUpdateContactPhone() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContactPhone("1", "0987654321");

        Contact updatedContact = contactService.getContact("1");
        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("123 Main St", updatedContact.getAddress());
    }

    // Test to verify updating contact's address
    @Test
    public void testUpdateContactAddress() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContactAddress("1", "456 Elm St");

        Contact updatedContact = contactService.getContact("1");
        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }

    // Test to verify updating non-existing contact
    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContactFirstName("999", "Jane");
        });
    }
}
