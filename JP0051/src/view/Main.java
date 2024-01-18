/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Manager;

/**
 *
 * @author NhatHoang
 */
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
         while (true) {
            int choice = manager.mennu();
            switch (choice) {
                case 1:
                    manager.normalCalculator();
                    break;
                case 2:
                    manager.BMICalculator();
                    break;
                case 3:
                    return;
            }
        }
    }
}
