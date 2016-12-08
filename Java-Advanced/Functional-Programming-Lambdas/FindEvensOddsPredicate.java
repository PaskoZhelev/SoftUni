/*
You are given a lower and an upper bound for a range of integer numbers.
Then a command specifies if you need to list all even or odd numbers in the given range. Use Predicate.
 */
package javaadvanced;

import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOddsPredicate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputNums = sc.nextLine();

        String[] numbers = inputNums.split("\\s+");
        int startNum = Integer.valueOf(numbers[0]);
        int endNum = Integer.valueOf(numbers[1]);

        String typeNums = sc.nextLine();

        Predicate<Integer> isEven = number -> number % 2 == 0;

        if (typeNums.equals("even")) {
            for (int i = startNum; i <= endNum; i++) {
                if (isEven.test(i)) {
                    System.out.printf("%d ", i);
                }
            }
            System.out.println();
        } else if (typeNums.equals("odd")) {
            for (int i = startNum; i <= endNum; i++) {
                if (!isEven.test(i)) {
                    System.out.printf("%d ", i);
                }
            }
            System.out.println();
        } else {
            System.out.println("Wrong input!");
        }

    }
}
