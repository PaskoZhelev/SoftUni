/*
Write a regular expression to match a valid full name. A valid full name consists of two words,
each word starts with a capital letter and contains only lowercase letters afterwards; each word
should be at least two letters long; the two words should be separated by a single space. 
 */
package javaadvanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MatchFullName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       String input = "";
       String regex = "\\b([A-Z][a-z]+) ([A-Z][a-z]+)\\b";
        Pattern pattern= Pattern.compile(regex);
        
       
       List<String> validNames = new ArrayList<>();
       
      while(!(input = sc.nextLine()).equals("end")) {
          Matcher matcher = pattern.matcher(input);
          
          if(matcher.find()) {
              validNames.add(input);
          }
      }
      
      for(String name: validNames) {
          System.out.println(name);
      }
    }
}
