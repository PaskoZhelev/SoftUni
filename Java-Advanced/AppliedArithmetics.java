/*
On the first line you are given a list of numbers. On the next lines you are
passed different commands that you need to apply to all numbers in the list:
"add" -> add 1; "multiply" -> multiply by 2; "subtract" -> subtract 1; "print" ->
prints all numbers on a line. The input will end with an "end" command, after
which you need to print the result.
 */
package javaadvanced;

import java.util.Scanner;
import java.util.function.Consumer;

public class AppliedArithmetics {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String numsInput = sc.nextLine();
        String[] tokens = numsInput.split("\\s+");
        Integer[] numbers = new Integer[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = Integer.valueOf(tokens[i]);
        }

        Consumer<Integer[]> add = num -> {
            for (int i = 0; i < num.length; i++) {
                numbers[i] = numbers[i] + 1;
            }
        };
        Consumer<Integer[]> subtract = num -> {
            for (int i = 0; i < num.length; i++) {
                numbers[i] = numbers[i] - 1;
            }
        };
        Consumer<Integer[]> multiply = num -> {
            for (int i = 0; i < num.length; i++) {
                numbers[i] = numbers[i] * 2;
            }
        };
        Consumer<Integer[]> print = nums -> {
            for (int digit : nums) {
                System.out.printf("%d ", digit);
            }

        };

        String input = "";
        while (!(input = sc.nextLine()).equals("end")) {
            switch (input) {
                case "add":
                    add.accept(numbers);
                    break;
                case "subtract":
                    subtract.accept(numbers);
                    break;
                case "multiply":
                    multiply.accept(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    break;
            }
        }
    }
}
