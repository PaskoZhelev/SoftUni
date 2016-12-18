/*
You are a young and talented developer. The first task you need to do is to implement a 
filtering module to a party reservation software. First, The Party Reservation Filter Module
(TPRF Module for short) is passed a list with invitations. Next the TPRF receives a sequence
of commands that specify if you need to add or remove a given filter. 
TPRF Commands are in the given format {command;filter type;filter parameter}
You can receive the following TPRF commands: "Add filter", "Remove filter" or "Print".
The possible TPRF filter types are: "Starts with", "Ends with", "Length" and "Contains".
All TPRF filter parameters will be a string (or an integer for the length filter).
The input will end with a "Print" command.

 */
package javaadvanced;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;


public class PartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        List<String> names = Arrays.asList(input.split("\\s+"));
        HashMap<String, Predicate<String>> predicates = new HashMap<>();
        
        while (!(input=sc.nextLine()).equals("Print")) {
            String[] tokens = input.split(";");
            
            String command = tokens[0];
            String type = tokens[1];
            String parameter = tokens[2];
                       
            
            Predicate<String> tester = createPredicate(type, parameter);
            
            if (command.equals("Add filter")) {
                predicates.put((type + parameter), tester);                 //key = type + parameter (f.e. Starts WithM
            } else if (command.equals("Remove filter")) {
                String testerKey = type + parameter;
                HashMap<String, Predicate<String>> mapClone = new HashMap<>(predicates);
                
                for (String predicateKey: predicates.keySet()) {
                    if (predicateKey.equals(testerKey)) {  
                        mapClone.remove(predicateKey);
                    }
                }
                predicates = mapClone;
            }                                
        }
        
        
        
        for (String name: names) {
            boolean isFeasible = false;
            for(Predicate<String> predicate: predicates.values()) {
                if (predicate.test(name)) {
                    isFeasible = false;
                    break;
                } else {
                    isFeasible = true;
                }
            }
            
            if (isFeasible) {
                System.out.print(name + " ");
            }
        }
    }

    private static Predicate<String> createPredicate(String type, String parameter) {
        switch(type) {
            case "Starts with":
                return person -> person.startsWith(parameter);
            case "Ends with":
                return person -> person.endsWith(parameter);
            case "Length":
                return person -> person.length() ==  Integer.valueOf(parameter);
            case "Contains":
                return person -> person.contains(parameter);
            default:
                return null;
        }
        
    }
}
