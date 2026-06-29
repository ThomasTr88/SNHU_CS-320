package contactservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact(
                "12345",
                "Thomas",
                "Tran",
                "1234567890",
                "123 Main Street");
    }

    @Test
    public void testContactCreation() {
        assertEquals("12345", contact.getContactId());
        assertEquals("Thomas", contact.getFirstName());
        assertEquals("Tran", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Thomas", "Tran", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testContactIdCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("", "Thomas", "Tran", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testContactIdCannotBeLongerThanTen() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Thomas", "Tran", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Tran", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "", "Tran", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testFirstNameCannotBeLongerThanTen() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "ThomasLong1", "Tran", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Thomas", null, "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testLastNameCannotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Thomas", "", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testLastNameCannotBeLongerThanTen() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Thomas", "TranLong123", "1234567890", "123 Main Street");
        });
    }

    @Test
    public void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Thomas", "Tran", null, "123 Main Street");
        });
    }

    @Test
    public void testPhoneCannotBeTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Thomas", "Tran", "123", "123 Main Street");
        });
    }

    @Test
    public void testPhoneCannotBeNonNumeric() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Thomas", "Tran", "12345abcde", "123 Main Street");
        });
    }

    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Thomas", "Tran", "1234567890", null);
        });
    }

    @Test
    public void testAddressCannotBeLongerThanThirty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Thomas", "Tran", "1234567890",
                    "1234567890123456789012345678901");
        });
    }

    @Test
    public void testSetFirstName() {
        contact.setFirstName("John");
        assertEquals("John", contact.getFirstName());
    }

    @Test
    public void testSetFirstNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("");
        });
    }

    @Test
    public void testSetLastName() {
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testSetLastNameInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("");
        });
    }

    @Test
    public void testSetPhone() {
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testSetPhoneInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345abcde");
        });
    }

    @Test
    public void testSetAddress() {
        contact.setAddress("456 Oak Street");
        assertEquals("456 Oak Street", contact.getAddress());
    }

    @Test
    public void testSetAddressInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("1234567890123456789012345678901");
        });
    }

    @Test
    public void testBoundaryValues() {
        assertDoesNotThrow(() -> {
            new Contact(
                    "1234567890",
                    "Firstname1",
                    "Lastname12",
                    "1234567890",
                    "123456789012345678901234567890");
        });
    }
    
    @Test
    public void testSetFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    @Test
    public void testSetFirstNameCannotBeLongerThanTen() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("ThomasLong1");
        });
    }

    @Test
    public void testSetLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    @Test
    public void testSetLastNameCannotBeLongerThanTen() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("TranLong123");
        });
    }

    @Test
    public void testSetPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
    }

    @Test
    public void testSetAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }
}