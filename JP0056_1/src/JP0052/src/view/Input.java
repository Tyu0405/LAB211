/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static controller.Constant.REGEX_STRING_NAME;
import controller.Valid;
import model.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ROG
 */
public class Input {
    public static String inputValidName() {
        String NAME = Valid.getString("Enter name of country:", "re-input name", REGEX_STRING_NAME);
        return NAME;
    }

    public static String inputValidTerrain()  {     
        String TERRAIN = Valid.getString("Enter terrain of country:", "re-input terrain", REGEX_STRING_NAME);
        return TERRAIN;
    }

    public static String inputValidID(ArrayList<EastAsiaCountries> countries)  {
        
        String ID = Valid.getString("Enter ID: ", "re-input ID", REGEX_STRING_NAME);
        return ID;
       
    }
    public static float inputValidArea() {      
        float area = Valid.getFloat("Input area: ", "re-input", 0, Float.MAX_VALUE);
        return area;
    }
    
    
}

