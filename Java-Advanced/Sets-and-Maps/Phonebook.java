/*
Write a program that receives some info from the console about people and their phone numbers.
You are free to choose the manner in which the data is entered; each entry should have just one name and one number (both of them strings).
If you receive a name that already exists in the phonebook, simply update its number.
After filling this simple phonebook, upon receiving the command "search", your program should be able to perform a search of a contact by name
and print her details in format "{name} -> {number}". In case the contact isn't found, print "Contact {name} does not exist."

 */
package javaadvanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Phonebook {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        System.out.println("Add a contact (name-phone number): ");
        String input = sc.nextLine();

        while (!"search".equals(input)) {
            String[] token = input.split("-");
            String name = token[0];
            String number = token[1];

            map.put(name, number);
            input = sc.nextLine();
        }
        System.out.println("Phone Number of: ");
        input = sc.nextLine();

        List<String> list = new ArrayList<>();
        while (!"stop".equals(input)) {
            list.add(input);
            input = sc.nextLine();
        }

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if (map.containsKey(name)) {
                System.out.printf("%s -> %s", name, map.get(name));
                System.out.println();
            } else {
                System.out.printf("Contact %s does not exist.", name);
                System.out.println();
            }
        }

    }
}
