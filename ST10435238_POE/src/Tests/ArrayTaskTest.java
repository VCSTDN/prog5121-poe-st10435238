package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import main.Task;
import main.TaskManager;

public class ArrayTaskTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        // Redirect System.out to capture printed content
        System.setOut(new PrintStream(outContent));

        // Reset the TaskManager before each test
        TaskManager.tasks = new Task[100];
        TaskManager.count = 0;

        // Populate with test data
        TaskManager.tasks[TaskManager.count++] = new Task("Create Login", "Login functionality", "Mike Smith", 5, "To Do");
        TaskManager.tasks[TaskManager.count++] = new Task("Create Add Features", "Add new features", "Edward Harrison", 8, "Doing");
        TaskManager.tasks[TaskManager.count++] = new Task("Create Reports", "Report generation", "Samantha Paulson", 2, "Done");
        TaskManager.tasks[TaskManager.count++] = new Task("Add Arrays", "Add array functionality", "Glenda Oberholzer", 11, "To Do");
    }

    @AfterEach
    public void restoreStreams() {
        // Restore original System.out after each test
        System.setOut(originalOut);
    }

    @Test
    public void testDeveloperArrayCorrectlyPopulated() {
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        for (int i = 0; i < TaskManager.count; i++) {
            assertEquals(expectedDevelopers[i], TaskManager.tasks[i].getDeveloperName());
        }
    }

    @Test
    public void testDisplayLongestTask() {
        Task longestTask = TaskManager.tasks[0];
        for (int i = 1; i < TaskManager.count; i++) {
            if (TaskManager.tasks[i].getTaskDuration() > longestTask.getTaskDuration()) {
                longestTask = TaskManager.tasks[i];
            }
        }
        assertEquals("Glenda Oberholzer", longestTask.getDeveloperName());
        assertEquals(11, longestTask.getTaskDuration());
    }

    @Test
    public void testSearchTaskByTaskName() {
        Task task = null;
        for (int i = 0; i < TaskManager.count; i++) {
            if (TaskManager.tasks[i].getTaskName().equalsIgnoreCase("Create Login")) {
                task = TaskManager.tasks[i];
                break;
            }
        }
        assertNotNull(task);
        assertEquals("Mike Smith", task.getDeveloperName());
        assertEquals("Create Login", task.getTaskName());
    }

    @Test
    public void testSearchTasksByDeveloperName() {
        String developerName = "Samantha Paulson";
        boolean found = false;
        for (int i = 0; i < TaskManager.count; i++) {
            if (TaskManager.tasks[i].getDeveloperName().equalsIgnoreCase(developerName)) {
                assertEquals("Create Reports", TaskManager.tasks[i].getTaskName());
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testDeleteTaskByName() {
        String taskNameToDelete = "Create Reports";
        boolean deleted = false;
        
        for (int i = 0; i < TaskManager.count; i++) {
            if (TaskManager.tasks[i] != null && TaskManager.tasks[i].getTaskName().equalsIgnoreCase(taskNameToDelete)) {
                // Shift elements to remove the task at index i
                for (int j = i; j < TaskManager.count - 1; j++) {
                    TaskManager.tasks[j] = TaskManager.tasks[j + 1];
                }
                TaskManager.tasks[TaskManager.count - 1] = null; // Optional: Clear last element
                deleted = true;
                break;
            }
        }
        
        if (deleted) {
            TaskManager.count--;
        }
        
        assertTrue(deleted);
        
        // Ensure the task is removed by checking all remaining tasks
        boolean found = false;
        for (int i = 0; i < TaskManager.count; i++) {
            if (taskNameToDelete.equalsIgnoreCase(TaskManager.tasks[i].getTaskName())) {
                found = true;
                break;
            }
        }
        
        assertFalse(found);
    }

    @Test
    public void testShowTaskReport() {
        TaskManager.showTaskReport(); // Call the method that prints the task report

        // Define expected output based on test data, ensuring correct formatting
        String expectedOutput = "Task Report:\n" +
                                "Task ID: CR:0:ITH\n" +
                                "Task Name: Create Login\n" +
                                "Task Description: xxx\n" +
                                "Developer Name: Mike Smith\n" +
                                "Task Duration: 5.0\n" +
                                "Task Status: To Do\n" +
                                "Task ID: CR:1:SON\n" +
                                "Task Name: Create Add Features\n" +
                                "Task Description: xxx\n" +
                                "Developer Name: Edward Harrison\n" +
                                "Task Duration: 8.0\n" +
                                "Task Status: Doing\n" +
                                "Task ID: CR:2:SON\n" +
                                "Task Name: Create Reports\n" +
                                "Task Description: xxx\n" +
                                "Developer Name: Samantha Paulson\n" +
                                "Task Duration: 2.0\n" +
                                "Task Status: Done\n" +
                                "Task ID: AD:3:ZER" +
                                "Task Name: Add Arrays\n" +
                                "Task Description:\n" +
                                "Developer Name: Glenda Oberholzer\n" +
                                "Task Duration: 11.0\n" +
                                "Task Status: To Do\n" +
                                "Total Hours: 26.0\n";

        // Assert that the printed output matches the expected output
        assertEquals(expectedOutput, outContent.toString());
    }

}
