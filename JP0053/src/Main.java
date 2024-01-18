
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NhatHoang
 */
public class Main {
     public static void main(String[] args) {
        int[] a = new int[0];
        //loop until user want to exit
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    a = inputValueOfArray();
                    break;
                case 2:
                    sortArrayAscending(a);
                    break;
                case 3:
                    sortArrayDescending(a);
                    break;
                case 4:
                    return;
            }
        }
    }
    
    
    private static final Scanner in = new Scanner(System.in);

    //check user input a number integer
    private static int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number.");
                System.err.print("Enter again: ");
            }
        }
    }

    //allow user input number of array
    private static int inputSizeOfArray() {
        System.out.println("Input Length Of Arrays");
        System.out.print("Enter number: ");
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                
                System.err.print("Enter again: ");
            }
        }
    }

    //allow user input value of array
    private static int[] inputValueOfArray() {
        int n = inputSizeOfArray();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = checkInputInt();
        }
        return a;
    }

    //sort array ascending by bubble sort
    private static void sortArrayAscending(int[] a) {
        int len = a.length;
        if (len == 0) {
            System.err.println("List empty.");
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.print("[" + a[i] + "]");
                break;
            }
            System.out.print("[" + a[i] + "], ");
        }
        System.out.println();
    }

    //sort array ascending by bubble sort
    private static void sortArrayDescending(int[] a) {
        int len = a.length;
        if (len == 0) {
            System.err.println("List empty.");
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.print("[" + a[i] + "]");
                break;
            }
            System.out.print("[" + a[i] + "],");
        }
        System.out.println();
    }

    private static int menu() {
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Desceding");
        System.out.println("4. Exit.");
        System.out.print("Enter your choice: ");
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                if (result < 1 || result > 4) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer 1 to 4.");
                System.out.print("Enter again: ");
            }
        }
    }

   
    
}
