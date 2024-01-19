
import java.util.Random;
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
        System.out.println("Enter size off arr: ");
        int n = checkInputInt();
        int[] randomArr = ramdomArray(n);
        System.out.println("Enter search value : ");
        int searchValue = checkInputInt();
        displayArray(randomArr);
        int indexFound = linearSearch(searchValue, randomArr);
        System.out.println("Found " + searchValue + " at index " + indexFound );
        
    }
    private final static Scanner in = new Scanner(System.in);
    public static int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number int");
                
            }
        }
    }
    
    private static int[] ramdomArray(int n){
        Random random = new Random();
        int[] array = new int[n];
        for(int i = 0; i< n; i++) {
            array[i] = random.nextInt(n);
        }
        return array;
    }
    private static void displayArray(int[] array){
        String flag=", ";
        System.out.print("The array: [");
        for(int i = 0; i< array.length; i++){
            if(i == array.length-1){
                flag = "]\n";
            }
            System.out.print(array[i]+flag);
        }
    }
    private static int linearSearch(int sreachValue, int[] array ){
        int indexFound = -1;
        for(int i = 0; i< array.length;i++) {
            if(array[i] == sreachValue) {
                indexFound =i;
                return indexFound;
            }
        }
        return indexFound;
    }
    
}
