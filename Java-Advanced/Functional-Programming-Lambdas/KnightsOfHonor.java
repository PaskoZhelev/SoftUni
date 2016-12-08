/*
Write a program that reads a collection of names as strings from the console then
appends “Sir” in front of every name and prints it back onto the console. Use Consumer<T>.
 */
package javaadvanced;

import java.util.Scanner;
import java.util.function.BiConsumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        
        String[] names = input.split("\\s+");
        
        String title = "Sir";        
        BiConsumer<String, String> nameWithTitle = (sir , name) -> System.out.printf("%s %s%n", sir,name);
        
        for(String word : names) {
            nameWithTitle.accept(title, word);
        }
    }
}
