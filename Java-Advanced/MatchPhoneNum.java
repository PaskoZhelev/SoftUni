/*
Write a regular expression to match a valid phone number from Sofia. A valid number
will start with "+359" followed by the area code (2) and then the number itself, consisting
of 7 digits (separated in two group of 3 and 4 digits respectively). The different parts of
the number are separated by either a space or a hyphen ('-').  
 */
package javaadvanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MatchPhoneNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        String regex = "( |)\\+359(-| )2\\2\\d{3}\\2\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        
        List<String> validPhoneNums = new ArrayList<>();
        
        while(!(input = sc.nextLine()).equals("end")) {
            Matcher matcher = pattern.matcher(input);
            
            if(matcher.find()) {
                validPhoneNums.add(input);
            }
        }
        
         for(String num:validPhoneNums) {
             System.out.println(num);
         }      
    }
}
