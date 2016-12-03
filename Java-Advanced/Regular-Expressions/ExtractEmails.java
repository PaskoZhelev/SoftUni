/*
Write a program to extract all email addresses from a given text. The text comes at the only
input line. Print the emails on the console, each at a separate line. Emails are considered to be in format <user>@<host>

 */
package javaadvanced;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String regex = "[\\w\\d][a-z\\d-_.]+@[a-z-.]+[.]\\w+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        String email = "";
        while (matcher.find()) {
            email = matcher.group();
            System.out.println(email);
        }

    }
}
