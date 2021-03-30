package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {
    public static final String PHONE  = "[(]?\\d{3}[-.)]?[ ]?\\d{3}[-.]?\\d{4}\\b";
    public static final String EMAIL = "\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b";
    public static final String USERNAME = "[a-zA-Z][a-zA-Z0-9-_]{3,32}";
    //Passwords between 8 & 64 characters must contain atleast one number
    public static final String PASSWORD = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{8,64})"; 
    
    public static boolean validate(String data, String pattern){
        if(data.matches(pattern)){
            return true;
        }else{
            return false;
        }
    }
    
}
