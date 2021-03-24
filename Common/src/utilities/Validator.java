package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {
    public static final String PHONE  = "[(]?\\d{3}[-.)]?[ ]?\\d{3}[-.]?\\d{4}\\b";
    public static final String EMAIL = "";
    
    public static boolean validate(String data, String pattern){
        if(data.matches(pattern)){
            return true;
        }else{
            return false;
        }
    }
}
