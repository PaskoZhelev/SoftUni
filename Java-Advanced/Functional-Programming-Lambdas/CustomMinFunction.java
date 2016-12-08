/*
Write a simple program that reads from the console a set of numbers and a
simple Function<Integer[], Integer> that finds the smallest of the numbers.
 */
package javaadvanced;

import java.util.Scanner;
import java.util.function.Function;


public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        String[] numbers = input.split("\\s+");
        Integer[] numbersInteger = new Integer[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            numbersInteger[i] = Integer.valueOf(numbers[i]);
        }
   
        Function<Integer[],Integer> smallestNumber = numbersArray -> {      //give the Function Integer[] and it will return Integer
            int smallest = Integer.MAX_VALUE;
            for(int digit: numbersArray){
                if (digit < smallest ) {
                    smallest = digit;
                }
            }
            return smallest;
        };
        
        System.out.println(smallestNumber.apply(numbersInteger));
    }
}
