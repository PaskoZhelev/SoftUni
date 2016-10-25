/*
You will be given an integer N representing the amount of elements to enqueue (add),
an integer S representing the amount of elements to dequeue (remove/poll) from the queue and finally an integer X,
an element that you should check whether is present in the queue. If it is print true on the console,
if it’s not print the smallest element currently present in the queue.
 */
package programmingfundamentals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Pasko
 */
public class BasicQueueOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //elements to add
        int s = sc.nextInt();   //elements to remove
        int x = sc.nextInt();   //element to check

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(sc.nextInt());
        }

        for (int j = 0; j < s; j++) {
            queue.poll();
        }

        if (queue.contains(x)) {
            System.out.println(true);
        } else if (!queue.isEmpty()) {
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < queue.size(); k++) {
                int currentElem = queue.poll();
                if (currentElem < min) {
                    min = currentElem;
                }
            }
            System.out.println(min);
        } else {
            System.out.println("0");
        }

    }

}
