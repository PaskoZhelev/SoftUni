/*
Print all students from group number 2. Use a Stream query. Order the students by FirstName.
 */
package javaadvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class StudentsByGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        Map<String, Integer> names = new LinkedHashMap<>();

        while (!(input = sc.nextLine()).equals("END")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0] + " " + tokens[1];
            int group = Integer.valueOf(tokens[2]);

            names.put(name, group);
        }
        
        names.entrySet().stream()
                .filter(entry -> entry.getValue() == 2)
                .sorted((n1,n2) -> n1.getKey().compareTo(n2.getKey()))
                .forEach(name -> System.out.println(name.getKey()));
             

    }
}
