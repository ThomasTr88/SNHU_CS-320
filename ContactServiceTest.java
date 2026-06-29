package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    public void setUp() {
        service = new ContactService();

        contact = new Contact(
                "12345",
                "Thomas",
                "Tran",
                "1234567890",
                "123 Main Street");
    }

    @Test
    public void testAddContact() {
        service.addContact(contact);

        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    public void testAddDuplicateContactId() {
        Contact duplicate = new Contact(
                "12345",
                "John",
                "Smith",
                "0987654321",
                "456 Oak Street");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(duplicate);
        });
    }

    @Test
    public void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    @Test
    public void testDeleteContact() {
        service.addContact(contact);

        service.deleteContact("12345");

        assertNull(service.getContact("12345"));
    }

    @Test
    public void testDeleteContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("99999");
        });
    }

    @Test
    public void testUpdateFirstName() {
        service.addContact(contact);

        service.updateFirstName("12345", "John");

        assertEquals("John", service.getContact("12345").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        service.addContact(contact);

        service.updateLastName("12345", "Smith");

        assertEquals("Smith", service.getContact("12345").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        service.addContact(contact);

        service.updatePhone("12345", "0987654321");

        assertEquals("0987654321", service.getContact("12345").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        service.addContact(contact);

        service.updateAddress("12345", "456 Oak Street");

        assertEquals("456 Oak Street", service.getContact("12345").getAddress());
    }

    @Test
    public void testUpdateFirstNameContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("99999", "John");
        });
    }

    @Test
    public void testUpdateLastNameContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName("99999", "Smith");
        });
    }

    @Test
    public void testUpdatePhoneContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("99999", "0987654321");
        });
    }

    @Test
    public void testUpdateAddressContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateAddress("99999", "456 Oak Street");
        });
    }

    @Test
    public void testUpdateFirstNameInvalidValue() {
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("12345", "");
        });
    }

    @Test
    public void testUpdatePhoneInvalidValue() {
        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("12345", "12345abcde");
        });
    }
}