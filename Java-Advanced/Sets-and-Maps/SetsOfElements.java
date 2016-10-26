/*
 * On the first line you are given the length of two sets n and m. On the next n + m lines
there are n numbers that are in the first set and m numbers that are in the second one.
Find all non-repeating element that appears in both of them, and print them at the console
 */
package javaadvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstSetElem = sc.nextInt();
        int secondSetElem = sc.nextInt();

        HashSet<Integer> hsOne = new LinkedHashSet<>();
        HashSet<Integer> hsTwo = new LinkedHashSet<>();

        for (int a = 0; a < firstSetElem; a++) {
            hsOne.add(sc.nextInt());
        }
        for (int b = 0; b < secondSetElem; b++) {
            hsTwo.add(sc.nextInt());
        }

        for (Integer abc : hsOne) {
            if (hsTwo.contains(abc)) {
                System.out.printf("%d ", abc);
            }
        }
    }
}
