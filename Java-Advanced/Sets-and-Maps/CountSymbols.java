/*
Write a program that reads some text from the console and counts the occurrences of each character in it.
Print the results in alphabetical (lexicographical) order. 
 */
package javaadvanced;

import java.util.Scanner;
import java.util.TreeMap;


public class CountSymbols {
    
   public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = "SoftUni rocks";
        TreeMap<Character, Integer> tm = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            if (!tm.containsKey(current)) {
                tm.put(current, 1);
            } else {
                tm.put(current, tm.get(current) + 1);   //if the map contains already the letter, increase the value by 1
            }
        }

        tm.entrySet().stream().forEach(ch -> {
            System.out.format("%s: %d time/s\n", ch.getKey(), ch.getValue());

        });

    }
    
}
