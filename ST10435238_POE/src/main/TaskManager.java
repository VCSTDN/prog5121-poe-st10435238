package main;

public class TaskManager {
    public static Task[] tasks = new Task[100]; // To manage team members and other task-specific functionalities
    public static int count = 0;

    // Method to create a new task
    public static void createNewTask() {
        String taskName = Prompt.promptTaskName();
        String taskDescription = Prompt.promptTaskDescription();
        if (taskDescription.length() > 50) {
            System.out.println("Please enter a task description of less than 50 characters");
            return;
        }
        String developerName = Prompt.promptFirstName() + " " + Prompt.promptLastName();
        double taskDuration = Prompt.promptHour();
        Main.scanner.nextLine(); // Consume newline character
        String taskStatus = Prompt.promptTaskStatus();

        Task task = new Task(taskName, taskDescription, developerName, taskDuration, taskStatus);

        tasks[count] = task; // Store the task object to manage team members
        count++;
    }

    // Method to create multiple tasks
    public static void createTasks() {
        // Prompt user for number of tasks
        int n = Prompt.promptUserForNumberOfTasks();
        // Loop to create n tasks
        int i = 0;
        while (i < n) {
            System.out.println("Task " + i);
            createNewTask();
            i++;
        }
    }

    // Method to calculate total hours of all tasks
    public static double calculateTotalHours() {
        double totalHours = 0;
        for (int i = 0; i < count; i++) {
            totalHours += tasks[i].getTaskDuration();
        }
        return totalHours;
    }

    // Method to display task report
    public static void showTaskReport() {
        System.out.println("\nTask Report:");
        // Loop through tasks and print details from task array
        for (int i = 0; i < count; i++) {
            System.out.println("Task ID: " + tasks[i].getTaskId());
            System.out.println("Task Name: " + tasks[i].getTaskName());
            System.out.println("Task Description: " + tasks[i].getTaskDescription());
            System.out.println("Developer Name: " + tasks[i].getDeveloperName());
            System.out.println("Task Duration: " + tasks[i].getTaskDuration());
            System.out.println("Task Status: " + tasks[i].getTaskStatus());
        }
        System.out.println("Total Hours: " + calculateTotalHours());  
    }

 // Method to display tasks by developer name
    public static boolean searchTasksByDeveloperName() {
        String developerName = Prompt.promptFirstName() + " " + Prompt.promptLastName();
        boolean found = false;
        System.out.println("Tasks assigned to " + developerName + ":");
        for (int i = 0; i < count; i++) {
            if (tasks[i].getDeveloperName().equalsIgnoreCase(developerName)) {
                System.out.println("Task ID: " + tasks[i].getTaskId());
                System.out.println("Task Name: " + tasks[i].getTaskName());
                System.out.println("Task Duration: " + tasks[i].getTaskDuration());
                System.out.println("Task Status: " + tasks[i].getTaskStatus());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Task(s) not found for '" + developerName + "'.");
        }
        return found;
    }

    // Method to search for a task by task name
    public static boolean searchTaskByTaskName() {
        String taskName = Prompt.promptTaskName();
        for (int i = 0; i < count; i++) {
            if (tasks[i].getTaskName().equalsIgnoreCase(taskName)) {
                System.out.println("Task Name: " + tasks[i].getTaskName());
                System.out.println("Task ID: " + tasks[i].getTaskId());
                System.out.println("Developer Name: " + tasks[i].getDeveloperName());
                System.out.println("Task Duration: " + tasks[i].getTaskDuration());
                System.out.println("Task Status: " + tasks[i].getTaskStatus());
                return true;
            }
        }
        System.out.println("Task with name '" + taskName + "' not found.");
        return false;
    }

    // Method to search for a task by ID and display its details
    public static boolean searchTaskById() {
        String taskId = Prompt.promptTaskId();
        for (int i = 0; i < count; i++) {
            if (tasks[i].getTaskId().equalsIgnoreCase(taskId)) {
                System.out.println("Task ID: " + tasks[i].getTaskId());
                System.out.println("Task Name: " + tasks[i].getTaskName());
                System.out.println("Developer Name: " + tasks[i].getDeveloperName());
                System.out.println("Task Duration: " + tasks[i].getTaskDuration());
                System.out.println("Task Status: " + tasks[i].getTaskStatus());
                return true;
            }
        }
        System.out.println("No tasks found with the ID '" + taskId + "'.");
        return false;
    }

    // Method to display the developer and duration of the task with the longest duration
    public static boolean displayLongestTask() {
        double maxDuration = 0;
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (tasks[i].getTaskDuration() > maxDuration) {
                maxDuration = tasks[i].getTaskDuration();
                index = i;
            }
        }
        if (index != -1) {
            System.out.println("Task with the longest duration: " + tasks[index].getTaskName());
            System.out.println("Task ID: " + tasks[index].getTaskId());
            System.out.println("Developer Name: " + tasks[index].getDeveloperName());
            System.out.println("Task Duration: " + tasks[index].getTaskDuration());
            System.out.println("Task Status: " + tasks[index].getTaskStatus());
            return true;
        } else {
            System.out.println("No tasks found.");
            return false;
        }
    }

    // Method to display tasks with a specific status
    public static boolean displayTaskStatus() {
        String status = Prompt.promptTaskStatus();
        boolean found = false;
        System.out.println("Tasks with status '" + status + "':");
        for (int i = 0; i < count; i++) {
            if (tasks[i].getTaskStatus().equalsIgnoreCase(status)) {
                System.out.println("Task ID: " + tasks[i].getTaskId());
                System.out.println("Task Name: " + tasks[i].getTaskName());
                System.out.println("Developer Name: " + tasks[i].getDeveloperName());
                System.out.println("Task Duration: " + tasks[i].getTaskDuration());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found with the status '" + status + "'.");
        }
        return found;
    }

    // Method to delete a task using the task name
    public static boolean deleteTaskByName() {
        String deleteTaskName = Prompt.promptTaskName();
        for (int i = 0; i < count; i++) {
            if (tasks[i].getTaskName().equalsIgnoreCase(deleteTaskName)) {
                // Remove task details from task array
                for (int j = i; j < count - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
                count--;
                System.out.println("Task '" + deleteTaskName + "' deleted successfully.");
                return true;
            }
        }
        System.out.println("Task with name '" + deleteTaskName + "' not found.");
        return false;
    }
}
