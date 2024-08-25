package contact_service_milestone3;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {

    @Test
    public void testValidAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        Appointment appointment = new Appointment("1", futureDate, "Dentist appointment");
        assertEquals("1", appointment.getAppointmentID());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Dentist appointment", appointment.getDescription());
    }

    @Test
    public void testInvalidAppointmentID() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Dentist appointment");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Dentist appointment");
        });
    }

    @Test
    public void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // 1 day in the past
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", pastDate, "Dentist appointment");
        });
    }

    @Test
    public void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000); // 1 day in the future
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", futureDate, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1", futureDate, "This description is way too long and exceeds the allowed 50 characters");
        });
    }
}

