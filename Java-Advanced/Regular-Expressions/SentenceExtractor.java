/*
Write a program that reads a keyword and some text from the console and prints all sentences
from the text, containing that word. A sentence is any sequence of words ending with '.', '!' or '?'. 
 */
package javaadvanced;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SentenceExtractor {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String keyword = sc.nextLine();
        String text = sc.nextLine();
        String regex = "[^!.?]*" + "\\b" + keyword + "\\b" + "[^!.?]*[.?!]";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()) {
            System.out.println(matcher.group().trim());
        }
    }
}
