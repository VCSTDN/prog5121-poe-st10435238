package main;
public class Menu {

	// Enum for menu items
	enum Items {
		//(classwork/StudentManagementSystemDemo)
		Registration,
		Login,
		Exit,
	}
	
	// Method to display menu options
	public static void showMenuOptions() {
		//(classwork/StudentManagementSystemDemo)
        System.out.println("Please select one of the following options:\n");
		for (int i = 0;i  < Items.values().length; i++) {
			System.out.println(i + 1 + ") " + Items.values()[i]);
		}
		System.out.println("\nEnter option number: ");
	}
	
	// Method to prompt user for input and handle menu choices
	public static void promptUser() {
	    boolean validInput = false;
	    
	    while (!validInput) {
	        // Read user input
	        int choice = Main.scanner.nextInt();
	        Main.scanner.nextLine();  // Consume newline left-over
	    
	        switch (choice) {
	            case 1:
	                Registration.promptRegisterUser();
	                validInput = true;
	                break;
	            case 2:
	                Login.promptLoginUser();
	                validInput = true;
	                break;
	            case 3:
	                System.out.println("\nTerminating Program!\n");
	                validInput = true;
	                System.exit(0);  // Exit the program gracefully
	                break;
	            default:
	                System.out.println("\nInvalid Option Selected - Try Again");
	                showMenuOptions();  // Display menu again for valid input
	                break;
	        }
	    }
	}
}
