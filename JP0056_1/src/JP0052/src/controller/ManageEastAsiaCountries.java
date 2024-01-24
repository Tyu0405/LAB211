package controller;

import static controller.Constant.REGEX_STRING_NAME;
import view.Input;
import model.EastAsiaCountries;
import java.util.ArrayList;

public class ManageEastAsiaCountries {

    public static void addCountryInformation(ArrayList<EastAsiaCountries> countries) throws Exception {

            String code = Input.inputValidID(countries);
            if(productExistsWithID(countries, code)) {
                System.err.println("code exist");
                return;
            }
            String name = Input.inputValidName();

            float area = Input.inputValidArea();

            String terrain = Input.inputValidTerrain();

            countries.add(new EastAsiaCountries(terrain, code, name, area));
            System.err.println("Add Successs");
    }

    public static void getRecentlyEnteredInformation(ArrayList<EastAsiaCountries> countries) {
        //check if the array of Product is empty
        if (countries.isEmpty()) {
            System.err.println("countries list is empty!");

        } else {
            //print format 
            System.out.format("%10s%30s%30s%10s\n", "ID", "countryName", "total Area", "Terrain");
            //use for loop to check every element of country list
            for (int i = 0; i < countries.size(); i++) {
                if (i == countries.size() - 1) {
                    countries.get(i).display();
                }
            }
        }
    }

    public static void searchInformationByName(ArrayList<EastAsiaCountries> countries) throws Exception {
        //check if country list is empty
        if (countries.isEmpty()) {
            System.out.println("Country list is empty!");

        } else {

            // Requires the user to enter a search string
            String search = Valid.getString("Enter the name you want to searcch for :", "re-input string a-z(A-z)", REGEX_STRING_NAME);
            boolean found = false;

            for (int i = 0; i < countries.size(); i++) {
                EastAsiaCountries country = countries.get(i);

                // Check if the search string is equal in the employee's name
                if (country.getCountryName().contains(search)) {
                    // If there is a match, print the employee's information
                    //print format 
                    System.out.format("%10s%30s%30s%10s\n", "ID", "countryName", "total Area", "Terrain");

                    country.display();

                    found = true;
                }
            }

            //Check to see if any countries match the search
            if (!found) {
                System.out.println("No countries found matching the search term.");
            }

        }

    }

    public static void displaySortByNameAscending(ArrayList<EastAsiaCountries> countries) {

        //Check if country list is empty
        if (countries.isEmpty()) {
            System.out.println("country list is empty!");

        } else {
            //use for loop to country list array by country's salary
            // Outer loop to iterate through each element of the country array
            for (int i = 0; i < countries.size() - 1; i++) {
                // Inner loop to compare and swap if necessary
                for (int j = 0; j < countries.size() - 1; j++) {
                    String nameCountryFirst = countries.get(j).getCountryName().toLowerCase();
                    String nameCountrySecond = countries.get(j + 1).getCountryName().toLowerCase();
                    int result = nameCountryFirst.compareTo(nameCountrySecond);
                    // If the salary of the j country is greater than the j+1 country then the swap
                    if (result < 0) {
                        EastAsiaCountries temp = countries.get(j);
                        //use set(array list) to set new value for j = j+1
                        countries.set(j, countries.get(j + 1));
                        countries.set(j + 1, temp);
                    }
                }
            }
            //access to display class then use displayList to display info of countries
            //print format 
            System.out.format("%10s%30s%30s%10s\n", "ID", "countryName", "total Area", "Terrain");
            //use for loop to check every element of country list
            for (int i = 0; i < countries.size(); i++) {

                countries.get(i).display();

            }
        }

    }
    
    private static boolean productExistsWithID(ArrayList<EastAsiaCountries> Countries, String id) {
        for (EastAsiaCountries country : Countries) {
            if (country.getCountryCode().toLowerCase().equals(id.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}
