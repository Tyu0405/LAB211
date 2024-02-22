/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

/**
 *
 * @author NhatHoang
 */
public class Valid {
    public static Scanner scanner = new Scanner(System.in);
     
    public static int getInteger(String message, String error, int min, int max) {
        while (true) {
            try {
                //hiển thị thông báo, yêu cầu người dùng
                System.out.println(message);
                //cho người dùng nhập vào
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                //kiểm tra xem giá trị đầu vào có trong đoạn min - max
                //if number in range => return number
                if (number >= min && number <= max) {
                    return number;
                    //else tell error
                } else {
                    System.out.println("Number must in range " + min + " - " + max);
                }

            } catch (NumberFormatException e) {
                System.err.println(error);
            }
        }
    }
    
    public static float getFloat(String message, String error, int min, int max) {
        while (true) {
            try {
                //hiển thị thông báo, yêu cầu người dùng
                System.out.println(message);
                //cho người dùng nhập vào
                String input = scanner.nextLine();
                float number = Float.parseFloat(input);
                //kiểm tra xem giá trị đầu vào có trong đoạn min - max
                //if number in range => return number
                if (number >= min && number <= max) {
                    return number;
                    //else tell error
                } else {
                    System.err.println("Number must in range " + min + " - " + max);
                }

            } catch (NumberFormatException e) {
                System.err.println(error);
            }
        }
    }

    
    public static double getDouble(String message, String error, double min, double max) {
        while (true) {
            try {
                //hiển thị thông báo, yêu cầu người dùng
                System.out.println(message);
                //cho người dùng nhập vào
                String input = scanner.nextLine();
                double number = Double.parseDouble(input);
                //kiểm tra xem giá trị đầu vào có trong đoạn min - max
                //if number in range => return number
                if (number >= min && number <= max) {
                    return number;
                    //else tell error
                } else {
                    System.err.println("Number must in range " + min + " - " + max);
                }

            } catch (NumberFormatException e) {
                System.err.println(error);
            }
        }
    }

    
    public static String getString(String message, String error, String regex) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Input cannot be empty");
            } else if (input.matches(regex)) {
                return input;
            } else {
                System.err.println(error);
            }
        }

    }
    
    public static boolean checkCodeExist(ArrayList<Doctor> ls, String code) {
        for (Doctor doctor : ls) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
    public static  boolean checkDuplicate(ArrayList<Doctor> ld, String code,
            String name, String specialization, int availability) {
        //check from first to last list doctor
        for (Doctor doctor : ld) {
            if (code.equalsIgnoreCase(doctor.getCode())
                    && name.equalsIgnoreCase(doctor.getName())
                    && specialization.equalsIgnoreCase(doctor.getSpecialization())
                    && availability == doctor.getAvailability()) {
                return false;
            }
        }
        return true;
    }

    //check user change infomation or not
    public static  boolean checkChangeInfo(Doctor doctor, String code,
            String name, String specialization, int availability) {
        if (doctor.getCode().equalsIgnoreCase(code)
                && doctor.getName().equalsIgnoreCase(name)
                && doctor.getSpecialization().equalsIgnoreCase(specialization)
                && doctor.getAvailability() == availability) {
            return false;
        }
        return true;
    }
}
