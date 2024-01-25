

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Step 1: Input array size
        int num = InputArraySize("Enter number of array: ");
        
        // Step 2: Generate array
        int[] arr = generateArray(num);
        
        // Step 3: Input search number
        int numSearch = InputSearchNumber("Enter search value: ");
        
        // Step 4: displayArray
        displayArr(arr, "The array: ");
        
        // Step 5: find index of search number in array
        int index = findIndexInArr(arr, numSearch);
        
        // Step 6: display index that found
        displayIndex(index, numSearch);
    }

    private static int InputArraySize(String mess) {
        int num = 0;
        System.out.println(mess);
        // loop until user input true format
        while (true) {            
            try{
                num = Integer.parseInt(sc.nextLine().trim());
                if(num <= 0 )   throw new NumberFormatException();
                break;
            }catch (NumberFormatException ex){
                System.out.println("Please enter a positive integer.");
                System.out.print("Enter again: ");
            }
        }
        return num;
    }

    private static int[] generateArray(int num) {
        int [] arr = new int [num];
        Random ran = new Random();
        // get each random element in array
        for (int i = 0; i < num; i++) {
            arr[i] = ran.nextInt(num);
        }
        return arr;
    }

    private static int InputSearchNumber(String mess) {
        int num = 0;
        System.out.println(mess);
        // loop until user input true format
        while (true) {            
            try{
                num = Integer.parseInt(sc.nextLine().trim());
                if(num <= 0 )   throw new NumberFormatException();
                break;
            }catch (NumberFormatException ex){
                System.out.println("Please enter a positive integer.");
                System.out.print("Enter again: ");
            }
        }
        return num;        
    }

    private static void displayArr(int[] arr, String mess) {
        System.out.print(mess + "[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[arr.length - 1] + "]");
    }

    private static int findIndexInArr(int[] arr, int numSearch) {
        // loop to accessed the first element to the last element in array
        for (int i = 0; i < arr.length; i++) {
            // compare between the value of index in array and search number 
            if(arr[i] == numSearch) return i;
        }
        return -1;
    }
    

    private static void displayIndex(int index, int numberSearch) {
        System.out.println();
        if(index < 0)   
            System.out.println("Not found the number in array");
        else
            System.out.println("Found " + numberSearch + " at index: " + index);
    }

}
