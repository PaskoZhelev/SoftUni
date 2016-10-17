/*
Given a string of lowercase letters, determine the index of the character whose
removal will make the string a palindrome. If the string is already a palindrome, then print -1. 
There will always be a valid solution.
 */
package programmingfundamentals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Pasko
 */
public class PalindromeIndex {

    public static boolean isPolindrome(String input) {
        String[] token = input.split("");

        for (int i = 0; i < token.length; i++) {
            if (!token[i].equals(token[token.length - i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String input = "kayajk";
        String[] token = input.split("");

        if (isPolindrome(input)) {
            System.out.println("The word is a Polindrome");
        } else {
            System.out.println("The word can become a Polindrome by:");
            for (int i = 0; i < input.length(); i++) {
                List<String> list = new LinkedList<String>(Arrays.asList(token));
                list.remove(i);
                String join = String.join("", list);

                if (isPolindrome(join)) {
                    System.out.printf("Removing character index %d", i);
                    System.out.println();

                }
            }
        }

    }
}
