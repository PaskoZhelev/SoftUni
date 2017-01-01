/*
Write a program which is finds the biggest or the smallest element in an integer sequence. You will be given an integer array. Your task is to create three different functions which are:
1.	Finds the last biggest element in the sequence
2.	Finds the last smallest element in a sequences
3.	Collects as parameters the above two functions and produces as a result the element found.
Print the resulting index.

 */
package javaadvanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pasko
 */
public class BiggestSmallestInteger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] tokens = input.split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            numbers.add(Integer.valueOf(token));
        }

        String type = sc.nextLine();

        Function<List<Integer>, Integer> findLargest = (nums) -> Collections.max(nums);
        Function<List<Integer>, Integer> findSmallest = (nums) -> Collections.min(nums);

        TriFunction<Function<List<Integer>, Integer>, Function<List<Integer>, Integer>, String, Integer> findResult = (largest, smallest, parameter) -> {
            List<Integer> list = new ArrayList<>();
            String minMax = "";
            String evenOdd = "";
            String regex = "([a-z]+)([A-Z][a-z]+)";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(type);

            while (matcher.find()) {
                minMax = matcher.group(1);
                evenOdd = matcher.group(2);
            }
            if (evenOdd.equals("Even")) {
                for (Integer num : numbers) {
                    if (num % 2 == 0) {
                        list.add(num);
                    }
                }
            } else if (evenOdd.equals("Odd")) {
                for (Integer num : numbers) {
                    if (num % 2 != 0) {
                        list.add(num);
                    }
                }
            }

            switch (minMax) {
                case "min":
                    return smallest.apply(list);
                case "max":
                    return largest.apply(list);
                default:
                    return null;
            }
        };

        System.out.println(findResult.apply(findLargest, findSmallest, type));

    }

    @FunctionalInterface
    public interface TriFunction<T, U, V, R> {

        public R apply(T t, U u, V v);

        public default <W> TriFunction<T, U, V, W> andThen(Function<? super R, ? extends W> after) {
            Objects.requireNonNull(after);
            return (T t, U u, V v) -> after.apply(apply(t, u, v));
        }
    }

}
