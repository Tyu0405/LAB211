/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0001;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        // Step1:  Input the number of array
        int size = InputSizeOfArray();
        //Step2 : Genmerate array
        int arr[] = GenarateArray(size);
        //Step3: Display array affter Bubble Sort
        DisplayArray(arr, "Unsorted array: [");
        //Step4: Bubble Sort
        BubbleSort(arr);
        //Step5: Display array before Bubble Sort
        DisplayArray(arr, "\nSorted array: [");
    }

    public static int InputSizeOfArray() {
        Scanner sc = new Scanner(System.in);
        int size;
        // loop exits when user enter true value size of array
        while (true) {
            // user enter and check value number 
            try {
                System.out.println("Enter number of array:");
                size = Integer.parseInt(sc.nextLine());
                // compare value size with value minimum of array
                if (size <= 0) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
            }
        }
        return size;

    }

    public static int[] GenarateArray(int size) {
        int arr[] = new int[size];
        Random random = new Random();
        // loop use to access first elements to last elements
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }
        return arr;
    }

    public static void DisplayArray(int arr[], String msg) {
        System.out.print(msg);
        int size = arr.length;
        // loop use to acccess first elements to last elements
        for (int i = 0; i < size; i++) {
            // compare index with index last array
            if (i == size - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("]");
    }

    public static void BubbleSort(int arr[]) {
        int size = arr.length;

        // loop use to access first elemets to before last elements
        for (int i = 0; i < size - 1; i++) {
            // loop use to access first elements to before last elements unsorted
            // After the loop,sorted max element
            for (int j = 0; j < size - 1 - i; j++) {
                //compare 2 adjacent
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }

        }

    }

}
