package view;

import controller.ManageEastAsiaCountries;
import model.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<EastAsiaCountries> countries = new ArrayList<>();
        //use while loop for display menu and select option
        while (true) {
            //step1 : display menu
            displayMennu();
            //step2: input choice
            int choice = inputChoice();
            //step3: perform fucntion by selection
            switch (choice) {
                //perform fucntion add countries information
                case 1:
                    ManageEastAsiaCountries.addCountryInformation(countries);
                    break;
                     //perform fucntion display countries
                case 2:
                    ManageEastAsiaCountries.getRecentlyEnteredInformation(countries);
                    break;
                     //perform fucntion search countries
                case 3:
                    ManageEastAsiaCountries.searchInformationByName(countries);
                    break;
                     //perform fucntion display countries has sort by name in ascending order
                case 4:
                    ManageEastAsiaCountries.displaySortByNameAscending(countries);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void displayMennu() {
        System.out.println("\n\n----------------------------MENU-----------------------------");
        System.out.println("==========================================================================");
        System.out.println("1. Input the information of 11 countries in East Aisa");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-enterd name");
        System.out.println("4. Display the information of countries stored name in ascending order");
        System.out.println("5. exit");
        System.out.println("==========================================================================");
    }

    public static int inputChoice() {
        System.out.print("Enter your choice:");
        Scanner a = new Scanner(System.in);
        String b = a.nextLine();

        //while loop use for input valid choice
        while (true) {
            try {
                //check b if it's empty
                if (b.isEmpty()) {
                    //throw message 
                    throw new Exception("You must input number.");
                }
                //check if b is not a number
                //if it's not  number it will throw new exception 
                if (!b.matches("[0-9]+")) {
                    throw new Exception("Only accept valid choice number!");
                }
                //cast the variable to  double value and assign it to choice
                int choice = Integer.parseInt(b);
                //if choice is blew zero so throw exception
                if (choice < 0) {
                    throw new Exception("Only accept valid choice number!");
                }
                if (choice < 1 || choice > 5) {
                    throw new Exception("Only accept valid choice number from 1 to 5!");
                }
                return choice;

            } catch (Exception e) {
                System.out.println(e.getMessage());//3 message
                System.out.print("Enter your choice:");
                b = a.nextLine();
            }
        }

    }
}
