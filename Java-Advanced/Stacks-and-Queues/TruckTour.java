package programmingfundamentals;

/**
Suppose there is a circle. There are N petrol pumps on that circle. Petrol pumps are numbered 0 to (N−1) (both inclusive).
You have two pieces of information corresponding to each of the petrol pump: (1) the amount of petrol that particular petrol pump will give,
and (2) the distance from that petrol pump to the next petrol pump. Initially, you have a tank of infinite capacity carrying no petrol. 
You can start the tour at any of the petrol pumps. Calculate the first point from where the truck will be able to complete the circle.
Consider that the truck will stop at each of the petrol pumps. The truck will move one kilometer for each liter of the petrol.
* 
Input Format: The first line will contain the value of N.
The next N lines will contain a pair of integers each, i.e. the amount of petrol that petrol pump will give and the distance between that petrol
pump and the next petrol pump.
Output Format: An integer which will be the smallest index of the petrol pump from which we can start the tour.

 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class TruckTour {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of pumps: ");
        int n = sc.nextInt();
        List<PetrolStation> listStations = new ArrayList<>();
        Queue<PetrolStation> queuePumpStations = new ArrayDeque<>();

        System.out.println("Enter the petrol and the distance of each pump: ");

        for (int i = 0; i < n; i++) {
            PetrolStation ps = new PetrolStation(sc.nextInt(), sc.nextInt());

            listStations.add(ps);
            queuePumpStations.add(ps);
        }
       
       // System.out.println(successfulTour(listStations, queuePumpStations));
        
       while (!successfulTour(listStations, queuePumpStations)) {
            changeStartingPump(queuePumpStations);                       
        }
        
        for (int a = 0; a < listStations.size(); a++) {
            if (queuePumpStations.peek().equals(listStations.get(a))) {
                System.out.println(a);
            }
            
        }
       
    }

    public static boolean successfulTour(List<PetrolStation> list, Queue<PetrolStation> queue) {
        Queue<PetrolStation> queueCopy = new ArrayDeque<>(queue);
        
        int fuel = queueCopy.peek().getPetrol();            //the fuel of the starting pump
        boolean condition = false;

        for (int i = 0; i < list.size() - 1; i++) {
            PetrolStation firstElem = queueCopy.remove();       
            fuel = fuel - firstElem.getDistance();

            if (fuel >= 0) {
                fuel = fuel + queueCopy.peek().getPetrol();         //fuel + fuel of the next pump
                condition = true;
                
                if (i == list.size() - 2) {         //check last element (check if the fuel is sufficient to return back to the starting pump)
                    fuel = fuel - queueCopy.peek().getDistance();                   
                    if (fuel < 0) {         //insufficient fuel to return to the starting pump
                       condition = false; 
                    }
                }                
            } else {
                condition = false;
                break;
            }
        }
                     
        return condition;
    }

    public static void changeStartingPump(Queue<PetrolStation> queue) {
        PetrolStation firstElement = queue.remove();
        queue.add(firstElement);  //first element becomes last
    }

}

class PetrolStation {

    private int petrol;
    private int distance;

    public PetrolStation(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }

    public int getPetrol() {
        return petrol;
    }

    public int getDistance() {
        return distance;
    }

    public void setPetrol(int petrol) {
        this.petrol = petrol;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}
