/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author NhatHoang
 */
public class Valid {
    public static String getString(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            //Input
            String input = scanner.nextLine();
            //check to see if the input is empty or not
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!");
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
        Scanner scanner = new Scanner(System.in);

        //Requires the user to enter an integer
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
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


    public static float getFloat(String message, String error, float min, float max) {
        Scanner scanner = new Scanner(System.in);

        //Requires the user to enter an integer
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.err.println("Input cannot be empty !!");
                } else {
                    float number = Float.parseFloat(input);
                    //check number in range
                    if (number > min && number <= max) {
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
}
