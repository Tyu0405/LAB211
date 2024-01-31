/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.DoctorManager;
import controller.Valid;
import java.util.ArrayList;
import model.Doctor;

/**
 *
 * @author NhatHoang
 */
public class View {
    public static void main(String[] args) {
        Valid valid = new Valid();
        DoctorManager Manager = new DoctorManager();
        Input ip = new Input();
        //loop until user want to exit
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                     ip.inputDoctor();
                    break;
                case 2:
                    ip.updateDoctor();
                    break;
                case 3:
                    ip.deleteDoctor();
                    break;
                case 4:
                    ip.searchDoctor();
                    break;
                case 5:
                    return;
            } 
        
        
    }    
}
    //display menu  
     public static int menu() {
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");        
        int choice = Valid.getInteger("enter your choice", "input 1-5", 1, 5);
        return choice;
    }
}

