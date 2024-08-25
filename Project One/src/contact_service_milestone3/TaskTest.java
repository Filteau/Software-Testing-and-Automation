package contact_service_milestone3;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("1", "Test Task", "This is a test description.");
        assertEquals("1", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test description.", task.getDescription());
    }

    @Test
    public void testSetName() {
    	System.out.println("Inside testSetName");
        Task task = new Task("1", "Test Task", "This is a test description.");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    public void testSetDescription() {
        Task task = new Task("1", "Test Task", "This is a test description.");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }
}
