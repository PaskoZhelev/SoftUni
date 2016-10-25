/*
You will be given an integer N representing the amount of elements to push onto the stack,
an integer S representing the amount of elements to pop from the stack and finally an integer X,
an element that you should check whether is present in the stack. If it is print true on the console,
if it’s not print the smallest element currently present in the stack.
 */
package programmingfundamentals;

import java.util.Scanner;
import java.util.Stack;

public class BasicStackOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int x = sc.nextInt();

        Stack<Integer> stack = new Stack();
        boolean condition;

        for (int i = 0; i < n; i++) {    //push elements
            stack.push(sc.nextInt());
        }

        for (int j = 0; j < s; j++) {   //pop elements
            stack.pop();
        }

        if (stack.contains(x)) {
            condition = true;
            System.out.println(condition);
        } else {
            int min = 0;
            if (!stack.isEmpty()) {
                min = stack.firstElement();
                for (int a = 0; a < stack.size() - 1; a++) {
                    if (stack.get(a) >= stack.get(a + 1)) {
                        min = stack.get(a + 1);
                    }

                }
            }
            System.out.println(min);
        }
    }
}
