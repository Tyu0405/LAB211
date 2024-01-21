/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Worker;

/**
 *
 * @author NhatHoang
 */
public class Validate {
    private final static Scanner in = new Scanner(System.in);

    public static String getString(String message, String error, String regex) {
        
        while (true) {
            System.out.print(message);
            //Input
            String input = in.nextLine();
            //check to see if the input is empty or not
            if (input.isEmpty()) {
                System.err.println("Input cannot be empty !!");
            } else {
                //check to see if the input matches the regex or not
                //if matches with regex => return string
                if (input.matches(regex)) {
                    return input;
                } else {
                    //tell error
                    System.err.println(error);
                }
            }
        }
    }
    
     public static int getInteger(String message, String error, int min, int max) {
        Scanner inanner = new Scanner(System.in);

        //Requires the user to enter an integer
        while (true) {
            try {
                System.out.print(message);
                String input = inanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Input cannot be empty !!");
                } else {
                    int number = Integer.parseInt(input);
                    //check number in range
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("Number must in range" + min + "-" + max);
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println(error);
            }
        }
    }
    
    public static double getDouble(String message, String error, double min, double max) {
        
        //Requires the user to enter an integer
        while (true) {
            try {
                System.out.print(message);
                String input = in.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Input cannot be empty !!");
                } else {
                    double number = Double.parseDouble(input);
                    //check number in range
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("Number must in range " + min + "-" + max);
                    }
                }
            } catch (Exception e) {
                System.err.println(error);
            }
        }
    }

public static boolean checkIdExist(ArrayList<Worker> lw, String id) {
        //check from first to last list id worker exist or not
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())) {
                return true;
            }
        }
        return false;
    }

    //check worker duplicate
    public static boolean checkWorkerExist(ArrayList<Worker> lw, String id,
            String name, int age, int salary, String workLocation) {
        //check from first to last list worker  worker exist or not
        for (Worker worker : lw) {
            if (id.equalsIgnoreCase(worker.getId())
                    && name.equalsIgnoreCase(worker.getName())
                    && age == worker.getAge()
                    && salary == worker.getSalary()) {
                return false;
            }
        }
        return true;
    }
}
