package contact_service_milestone3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService taskService;

    // Initialize task service before each test
    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("1", "Test Task", "This is a test description.");
        taskService.addTask(task);
        assertNotNull(taskService.getTask("1"));
    }

    @Test
    public void testAddDuplicateTaskID() {
        Task task1 = new Task("1", "Test Task 1", "Description 1");
        Task task2 = new Task("1", "Test Task 2", "Description 2");
        taskService.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task2);
        });
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("1", "Test Task", "This is a test description.");
        taskService.addTask(task);
        taskService.deleteTask("1");
        assertNull(taskService.getTask("1"));
    }

    @Test
    public void testUpdateTaskName() {
        Task task = new Task("1", "Test Task", "This is a test description.");
        taskService.addTask(task);
        taskService.updateTaskName("1", "New Name");
        assertEquals("New Name", taskService.getTask("1").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        Task task = new Task("1", "Test Task", "This is a test description.");
        taskService.addTask(task);
        taskService.updateTaskDescription("1", "New Description");
        assertEquals("New Description", taskService.getTask("1").getDescription());
    }
}

