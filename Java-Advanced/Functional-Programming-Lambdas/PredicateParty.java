/*
The wire’s parents are on a vacation for the holidays and he is planning an epic party at home.
Unfortunately, his organizational skills are next to non-existent so you are given the task
to help him with the reservations.
On the first line you get a list with all the people that are coming. On the next lines, until
you get the "Party!" command, you may be asked to double or remove all the people that apply to
given criteria. There are three different options: 1. Everyone that has a name starting with a
given string; 2. Everyone that has a name ending with a given string; 3. Everyone that has a
name with a given length. 
If nobody is going, print "Nobody is going to the party!"

 */
package javaadvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;


public class PredicateParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        String input = sc.nextLine();
        List<String> names = Arrays.asList(input.split("\\s+"));
        
        while(!(input = sc.nextLine()).equals("Party!")) {
            String[] tokens = input.split("\\s+");
            
            String command = tokens[0];
            String modifier = tokens[1];
            String variable = tokens[2];
            Predicate<String> tester;
            
            tester = createPredicate(modifier, variable);
            
            
            if(command.equals("Remove")) {
                names = removeName(names,tester);
            }
            else if (command.equals("Double")) {
                names = doubleName(names, tester);
            }
        }
        
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.join(", ", names) + " are going to the party!");
        }
        
        }

    private static List<String> removeName(List<String> names, Predicate<String> tester) {
        List<String> result = new ArrayList<>();
        for(String name: names) {
            if(!tester.test(name)) {
                result.add(name);
            }
        }
        return result;
    }

    private static List<String> doubleName(List<String> names, Predicate<String> tester) {
        List<String> result = new ArrayList<>();
        
        for(String name: names) {
            if(tester.test(name)) {
                result.add(name);
            }
            
            result.add(name);
        }

        return result;
    }

    private static Predicate<String> createPredicate(String modifier, String variable) {
        switch (modifier) {
            case "StartsWith":
                return person -> person.startsWith(variable);
            case "EndsWith":
                return person -> person.endsWith(variable);
            case "Length":
                return person -> person.length() == Integer.valueOf(variable);
            default:
                return null;
        }
    }
}
