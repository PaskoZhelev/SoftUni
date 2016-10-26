/*
Write a simple program that reads from the console a sequence of usernames and keeps
a collection with only the unique ones. Print the collection on the console in order of insertion:
 */
package programmingfundamentals;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 *
 * @author Pasko
 */
public class UniqueUsernames {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashSet hs = new LinkedHashSet();

        System.out.println("Number of usernames: ");
        int n = sc.nextInt();

        System.out.println("Write the usernames followed by Enter key:");

        for (int i = 0; i < n; i++) {
            hs.add(sc.next());
        }

        System.out.println(hs);

    }

}
