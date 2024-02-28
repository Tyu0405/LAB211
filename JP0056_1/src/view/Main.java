/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Valid;
import model.HistorySalary;

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
                    1, 5);

            // Handle user selections
            switch (option) {
                case 1:
                    // Add a new task
                    ip.addWorker();
                    break;
                case 2:
                    ip.upSalary();

                    break;
                case 3:
                    // Display task list
                    ip.downSalary();
                    break;
                case 4:
                    ip.displayWorker();
                    break;
                case 5:
                    return;
            }
        }

    }
}
