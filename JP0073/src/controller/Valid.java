package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * The class contains utility methods for handling user input.
 *
 * @author trungnhhe172826
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
                    System.out.println(error);
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

    public static double getDouble(String message, String error, double min, double max) {
        Scanner scanner = new Scanner(System.in);

        //Requires the user to enter an integer
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
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

   

    public static Date inputDateWithFormat(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        while (true) {
            System.out.println(message);
            //input 

            try {
                String input = scanner.nextLine();
                //check input in format dd-MM-yyyy
                if (input.matches(regex) && isDateExist(input)) //check input date exist ?
                {
                    date = dateFormat.parse(input);
                    return date;
                } else throw new Exception();
            } catch (Exception ex) {
                System.err.println(error);
            }
        }

    }

    private static boolean isDateExist(String inputDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(inputDate);
            //check parse success => date exist => return true
            return true;
        } catch (ParseException ex) {
            //parse failed => date not exist => return false
            return false;
        }
    }

}
