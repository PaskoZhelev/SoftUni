/*
Write a program that reads a string from the console and replaces all series of consecutive identical letters with a single one.
 */
package javaadvanced;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeriesOfLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String regex = "(\\w)\\1*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String letter = matcher.group();
            
            System.out.print(letter.charAt(0));
        }
        System.out.println();
    }
}
