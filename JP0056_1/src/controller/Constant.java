package controller;

/**
 * The class contains constants used in the program.
 * 
 * @author trungnhhe172826
 */
public class Constant {
  
    /** REGEX_STRING: [a-zA-Z0-9 ]+ */
    public static final String REGEX_STRING = "^[a-zA-Z0-9 ]+$";
    /** REGEX_DATE: \\d{1,2}[-]\\d{1,2}[-]\\d{1,4}  */
    public static final String REGEX_DATE = "\\d{1,2}[-]\\d{1,2}[-]\\d{4}";
    public static final String REGEX_CODE = "W\\d{1,3}";
    public static final String REGEX_NAME = "^(?!\\s)[a-zA-Z ]+$";

}