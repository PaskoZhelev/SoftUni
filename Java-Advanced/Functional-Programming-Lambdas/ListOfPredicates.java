/*
Find all numbers in the range 1..N that are divisible by the numbers of a given sequence. Use predicates.
 */
package javaadvanced;

import java.util.Scanner;
import java.util.function.Predicate;


public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.valueOf(sc.nextLine());
        String input = sc.nextLine();
        String[] tokens = input.split("\\s+");
        Integer[] sequence = new Integer[tokens.length];
        
        for(int i = 0; i < tokens.length; i++) {
            sequence[i] = Integer.valueOf(tokens[i]);
        }
        
        Predicate<Integer> divisible = num -> {
            boolean isDivisible = false;
            for(Integer divisor: sequence) {
                if (num % divisor == 0) {
                    isDivisible = true;
                }
                else {
                    isDivisible = false;
                    break;
                }
            }
            
            return isDivisible;
        };
        
        for(int a = 1; a <= n; a++) {
            if (divisible.test(a)) {
                System.out.printf("%d ", a);
            }
        }
        
        }
}
