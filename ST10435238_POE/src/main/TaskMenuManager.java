package main;

public class TaskMenuManager {
    // Enum to represent main menu items
    enum MainMenuItems {
        AddTask,
        ManageTasks,
        ReturnToMainMenu,
        Exit,
    }

    // Enum to represent manage tasks menu items
    enum ManageTasks {
        ShowTaskReport,
        SearchTasksByDeveloperName,
        SearchTaskByTaskName,
        SearchTaskByTaskId,
        DisplayLongestDurationTask,
        DisplayTaskStatus,
        DeleteTaskByTaskName,
        ReturnToTasklMainMenu,
    }

    // Method to display main menu items
    public static void showTaskMainMenuItems() {
        System.out.println("\nTask Main Menu\n");
        for (int i = 0; i < MainMenuItems.values().length; i++) {
            System.out.println(i + 1 + ") " + MainMenuItems.values()[i]);
        }
    }

    // Method to display manage tasks menu items
    public static void showManageTasksMenuItems() {
        System.out.println("\nManage Tasks\n");
        for (int i = 0; i < ManageTasks.values().length; i++) {
            System.out.println(i + 1 + ") " + ManageTasks.values()[i]);
        }
    }

    // Method to prompt user for main menu choice
    public static void promptUserForMainMenu() {
        int choice = Main.scanner.nextInt();
        Main.scanner.nextLine();
        switch (choice) {
            case 1:
                TaskManager.createTasks();
                TaskMenuManager.showTaskMainMenuItems();
                TaskMenuManager.promptUserForMainMenu();
                break;
            case 2:
            	TaskMenuManager.showManageTasksMenuItems();
            	TaskMenuManager.promptUserForManageTasks();
                break;
            case 3:
            	System.out.println("Returning to main menu...");
            	new Kanban();
            	break;
            case 4:
                System.out.println("Exiting the application...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice - Try Again!");
                new Kanban();
                break;
        }
    }

    // Method to prompt user for manage tasks menu choice
    public static void promptUserForManageTasks() {
        int choice = Main.scanner.nextInt();
        Main.scanner.nextLine();
        switch (choice) {
            case 1:
                TaskManager.showTaskReport();
    			TaskMenuManager.showManageTasksMenuItems();
    			TaskMenuManager.promptUserForManageTasks();
                break;
            case 2:
                TaskManager.searchTasksByDeveloperName();
    			TaskMenuManager.showManageTasksMenuItems();
    			TaskMenuManager.promptUserForManageTasks();
                break;
            case 3:
                TaskManager.searchTaskByTaskName();
    			TaskMenuManager.showManageTasksMenuItems();
    			TaskMenuManager.promptUserForManageTasks();
                break;
            case 4:
                TaskManager.searchTaskById();
    			TaskMenuManager.showManageTasksMenuItems();
    			TaskMenuManager.promptUserForManageTasks();
                break;
            case 5:
                TaskManager.displayLongestTask();
    			TaskMenuManager.showManageTasksMenuItems();
    			TaskMenuManager.promptUserForManageTasks();
                break;
            case 6:
                TaskManager.displayTaskStatus();
    			TaskMenuManager.showManageTasksMenuItems();
    			TaskMenuManager.promptUserForManageTasks();
                break;
            case 7:
                TaskManager.deleteTaskByName();
    			TaskMenuManager.showManageTasksMenuItems();
    			TaskMenuManager.promptUserForManageTasks();
                break;
            case 8:
                System.out.println("Returning to main menu...\n");
    			TaskMenuManager.showTaskMainMenuItems();
    			TaskMenuManager.promptUserForMainMenu();           
                break;
            default:
                System.out.println("Invalid Choice - Try Again\n");
                new Kanban();
                break;
        }
    }
}
