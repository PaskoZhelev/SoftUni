package programmingfundamentals;

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
