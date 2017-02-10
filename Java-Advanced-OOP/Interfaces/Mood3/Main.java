
package javaoopadvanced.Mood3;

import java.util.Scanner;
import javaoopadvanced.Mood3.models.DemonImpl;
import javaoopadvanced.Mood3.models.ArchangelImpl;
import javaoopadvanced.Mood3.interfaces.GameObject;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        String[] tokens = input.split("\\|");
        
        String username = tokens[0].trim();
        String charType = tokens[1].trim();
        
        switch(charType){
            case "Archangel":
                int mana = Integer.valueOf(tokens[2].trim());
                int levelArchangel = Integer.valueOf(tokens[3].trim());
                GameObject archangelObj = new ArchangelImpl(username, levelArchangel, charType, mana);
                archangelObj.generateHashedPassword(archangelObj);
                System.out.println(archangelObj.toString());
                break;
            case "Demon":
                double energy = Double.valueOf(tokens[2].trim());
                int levelDemon = Integer.valueOf(tokens[3].trim());
                GameObject demonObj = new DemonImpl(username, levelDemon, charType, energy);
                demonObj.generateHashedPassword(demonObj);
                System.out.println(demonObj.toString());
                break;
        }
        
        
        
    }
}
