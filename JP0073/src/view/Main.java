/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Valid;

/**
 *
 * @author slhoa
 */
public class Main {
    public static void main(String[] args) {
        Input ip = new Input();
        
       while (true) {
            // Display menu
            ip.menu();
            
            // Receive selection from user
            int option = Valid.getInteger("Option: ",
                                            "Option must be 1 - 4 ",
                                             1, 4);
            
            // Handle user selections
            switch (option) {
                case 1:
                    // Add a new task
                   ip.inputExpense();
                    break;
                case 2:
                    // Delete a task
                    ip.displayExpense();
                    break;
                case 3:
                    // Display task list
                    ip.deleteExpense();
                    break;
                case 4:
                    // Exit the program
                    
                    return;
            }
        } 
    }
}
