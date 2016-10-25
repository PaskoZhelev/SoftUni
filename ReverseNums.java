/*
 Write a program that reads N integers from the console and reverses them using a stack. Use the Stack<Integer> class.
Just put the input numbers in the stack and pop them.
 */
package programmingfundamentals;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Pasko
 */
public class ReverseNums {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack stack = new Stack();

        System.out.printf("Write %d numbers: ", n);
        System.out.println();

        for (int i = 0; i < n; i++) {   //fill the stack with elements
            int a = sc.nextInt();
            stack.push(a);
        }

        for (int j = 0; j < n; j++) {
            System.out.println(stack.pop());
        }

    }
}
