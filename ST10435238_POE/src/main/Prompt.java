package main;

public class Prompt {

    // Method to prompt the user for their user name
    public static String promptUserName() {
        // Prompt user to enter user name
        System.out.println("Enter username:");
        String username = Main.scanner.nextLine();
        return username;
    }
    // Method to prompt the user for their password
    public static String promptPassword() {
        // Prompt user to enter password
        System.out.println("Enter password:");
        String password = Main.scanner.nextLine();
        return password;
    }
    // Method to prompt the user for their first name
    public static String promptFirstName() {
        // Prompt user to enter first name
        System.out.println("Enter firstname:");
        String firstName = Main.scanner.nextLine();
        return firstName;
    }
    // Method to prompt the user for their last name
    public static String promptLastName() {
        // Prompt user to enter last name
        System.out.println("Enter lastname:");
        String lastName = Main.scanner.nextLine();
        return lastName;
    }
    
    // Method to prompt user for new user name
    public static String promptNewUserName() {
        // Prompt user to enter password
        System.out.println("Enter new username:");
        String username = Main.scanner.nextLine();
        return username;
    }
    // Method to prompt user for new password
    public static String promptNewPassword() {
        // Prompt user to enter password
        System.out.println("Enter new password:");
        String password = Main.scanner.nextLine();
        return password;
    }
    // Method to prompt user for new first name
    public static String promptNewFirstName() {
        // Prompt user to enter password
        System.out.println("Enter new firstname:");
        String firstName = Main.scanner.nextLine();
        return firstName;
    }
    // Method to prompt user for new last name
    public static String promptNewLastName() {
        // Prompt user to enter password
        System.out.println("Enter new lastname:");
        String lastName = Main.scanner.nextLine();
        return lastName;
    }
    
    // Method to prompt user for task name 
    public static String promptTaskName() {
        System.out.println("Please enter the task name:");
        String taskName = Main.scanner.nextLine();
		return taskName;	
	}
    
    public static String promptTaskDescription() {
		System.out.println("Enter task description:");
		String taskDescription = Main.scanner.nextLine();
		return taskDescription;
	}
    
    public static double promptHour() {
    	System.out.println("Enter task duration (in hours):");
        double taskDuration= Main.scanner.nextInt();
		return taskDuration;
	}
    // Method to prompt user for task status
    public static String promptTaskStatus() {
        System.out.println("Choose task status:");
        System.out.println("1) To Do");
        System.out.println("2) Done");
        System.out.println("3) Doing");
        String taskStatus = Main.scanner.nextLine();
        switch (taskStatus) {
            case "1":
                return "To Do";
            case "2":
                return "Done";
            case "3":
                return "Doing";
            default:
                System.out.println("Invalid choice");
                return null;
        }
    }
    // Method to prompt user for number of tasks
    public static int promptUserForNumberOfTasks() {
		System.out.print("Enter the Number of Tasks to Capture: ");
        int n = Main.scanner.nextInt();
        Main.scanner.nextLine();
        return n;
	}

    // Method to prompt user for task ID
    public static String promptTaskId() {
        System.out.println("Enter task ID:");
        String taskId = Main.scanner.nextLine();
        return taskId;
    }
}












