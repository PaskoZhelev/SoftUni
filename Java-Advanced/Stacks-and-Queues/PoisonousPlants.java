/*
You are given N plants in a garden. Each of these plants has been added with some amount of pesticide. After each day, 
if any plant has more pesticide than the plant at its left, being weaker(more GMO) than the left one, it dies. 
You are given the initial values of the pesticide and position of each plant. Print the number of days after which no plant dies, 
i.e. the time after which there are no plants with more pesticide content than the plant to their left.
Input Format: The input consists of an integer N representing the number of plants. The next single line consists of N integers where
every integer represents the position and amount of pesticides of each plant.
Output Format: Output a single value equal to the number of days after which no plants die

 */
package programmingfundamentals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 7;
        int days = 0;
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        List<Integer> plantsToRemove = new ArrayList<>();

        while(plantsDie(stack, plantsToRemove)) {
            removePlants(stack, plantsToRemove);
            days++;
        }
        
        System.out.println(days);
    }

    public static boolean plantsDie(Stack<Integer> stack, List<Integer> plantsToRemove) {
        plantsToRemove.clear();     

        for (int a = stack.size() - 1; a > 0; a--) {
            if (stack.get(a) > stack.get(a - 1)) {
                plantsToRemove.add(a);
            }
        }

        return !plantsToRemove.isEmpty();
    }
    
    public static void removePlants(Stack<Integer> stack, List<Integer> plantsToRemove) {
        for (int b = 0; b < plantsToRemove.size(); b++) {
            int elementToRemove = plantsToRemove.get(b);
            stack.remove(elementToRemove);
        }
    }

}
