/*
 You are part of the back-end development team of the next Facebook. You are given a line of usernames,
between one of the following symbols: space, “/”, “\”, “(“, “)”. First you have to export all valid usernames.
A valid username starts with a letter and can contain only letters, digits and “_”. It cannot be less than 3
or more than 25 symbols long. Your task is to sum the length of every 2 consecutive valid usernames and print
on the console the 2 valid usernames with biggest sum of their lengths, each on a separate line. 
 */
package javaadvanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String regex = "^[a-zA-Z][\\w_]{2,24}$";

        String[] tokens = input.split("[\\\\\\/\\s)(]");

        List<String> usernames = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);

        for (String name : tokens) {
            Matcher matcher = pattern.matcher(name);

            if (matcher.find()) {
                name = name.trim();
                usernames.add(name);
            }
        }

        int maxLenght = 0;
        String[] largestUsernames = new String[2];
        for (int i = 0; i < usernames.size(); i++) {
            if (i != usernames.size() - 1) {
                int consecutiveLenght = usernames.get(i).length() + usernames.get(i + 1).length();

                if (maxLenght < consecutiveLenght) {
                    maxLenght = consecutiveLenght;
                    largestUsernames[0] = usernames.get(i);
                    largestUsernames[1] = usernames.get(i + 1);
                }
            } else {
                int consecutiveLenght = usernames.get(i).length() + usernames.get(i - 1).length();

                if (maxLenght < consecutiveLenght) {
                    maxLenght = consecutiveLenght;
                    largestUsernames[0] = usernames.get(i);
                    largestUsernames[1] = usernames.get(i + 1);
                }
            }
        }

        for (String ex : largestUsernames) {
            System.out.println(ex);
        }
    }
}
