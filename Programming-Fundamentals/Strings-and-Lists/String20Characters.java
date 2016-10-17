/*
Write a program that reads from the console a string and fits the string in 20 characters as follows:
•	If the string has less than 20 characters, append some ‘*’ until it gets length of exactly 20 characters.
•	If the string length is more than 20 characters, discard all characters after the first 20.
Print the result string at the console.

 */
package programmingfundamentals;

import java.util.Scanner;

public class String20Characters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String abc = sc.nextLine();

        if (abc.length() < 20) {
            while (abc.length() != 20) {
                abc = abc + "*";
            }
        } else if (abc.length() > 20) {

            while (abc.length() != 20) {
                abc = abc.substring(0, abc.length() - 1);
            }
        }
        
        System.out.println(abc);

    }

}
