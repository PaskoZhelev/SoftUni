/*
Print all students with phones in Sofia (starting with 02 / +3592). Use a Stream.
 */
package javaadvanced;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class FilterByPhone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = "";
        List<String> names = new LinkedList<>();
        
        
        while(!(input = sc.nextLine()).equals("END")) {
            names.add(input);
        }
        
        names = names.stream()
                .filter(name -> {
                    String[] tokens = name.split("\\s+");
                    String firstName = tokens[0];
                    String lastName = tokens[1];
                    
                    return firstName.compareTo(lastName) < 0;
                    
                })
                .collect(Collectors.toList());
        
        names.stream().forEach(System.out::println);
              
    }
}
