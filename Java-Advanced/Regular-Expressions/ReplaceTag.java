/*
Write a program that replaces in a HTML document given as string all the tags
<a href=…>…</a> with corresponding tags [URL href=…>…[/URL]. Read an input, until
you receive “end” command. Print the result on the console. 
 */
package javaadvanced;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReplaceTag {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = "";
        StringBuffer buffer = new StringBuffer();
        String regex = "<a href=(\"[\\w\\W\\d]+\")>([\\w\\W\\s\\d]+)<\\/a>";
        Pattern pattern = Pattern.compile(regex);
        
        
        while(!(input = sc.nextLine()).equals("end")) {
             buffer.append(input);
        }
        
        String code = String.valueOf(buffer);
        Matcher matcher = pattern.matcher(code);
      
            if(matcher.find()) {     
                String replacement = "[URL href=" + matcher.group(1) +">" + matcher.group(2) + "[/URL]";
                code = code.replaceAll(regex, replacement);
            }
        System.out.println(code);
        
    }
}
