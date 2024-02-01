package view;

import model.Task;
import controller.Valid;

/**
 * The class contains the main method, which is the starting point of program
 * execution.
 *
 * @author trungnhhe172826
 */
public class Main {

    public static void main(String[] args) {
        // Create an object of ViewTask class to manage and display tasks
        ViewTask view = new ViewTask();
        
        while (true) {
            // Display menu
            view.displayMenu();
            
            // Receive selection from user
            int option = Valid.getInteger("Option: ",
                                            "Option must be digits 1- 4",
                                             1, 4);
            
            // Handle user selections
            switch (option) {
                case 1:
                    // Add a new task
                    view.inputTask();
                    break;
                case 2:
                    // Delete a task
                    view.deleteTask();
                    break;
                case 3:
                    // Display task list
                    view.displayTask();
                    break;
                case 4:
                    // Exit the program
                    System.exit(0);
                    break;
            }
        }

    }

    
}
