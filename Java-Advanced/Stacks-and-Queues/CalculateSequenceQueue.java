/*
•	S1 = N
•	S2 = S1 + 1
•	S3 = 2*S1 + 1
•	S4 = S1 + 2
•	S5 = S2 + 1
•	S6 = 2*S2 + 1
•	S7 = S2 + 2
        ...
Using the ArrayDeque<E> class, write a program to print its first 50 members for given N.
 */
package programmingfundamentals;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author Pasko
 */
public class CalculateSequenceQueue {
    public static void main(String[] args) {

        int x = 2;

        Queue<Integer> queue = new ArrayDeque<>();

        //queue.add(x);     
        int currentNum = x;

        System.out.println(x);
        for (int i = 0; i < 51; i++) {
            currentNum = queue.remove();
            System.out.print(currentNum + " ");
            int s1 = currentNum + 1;
            int s2 = 2 * currentNum + 1;
            int s3 = currentNum + 2;

            queue.add(s1);
            queue.add(s2);
            queue.add(s3);

        }

    }
}
