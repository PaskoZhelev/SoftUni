
package javaoopadvanced.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        List<Society> listSociety = new ArrayList<>();
        
        while(!(input = sc.nextLine()).equals("End")) {
            String[] tokens = input.split("\\s+");
            
            if(tokens.length == 3) {                        //citizen
                String name = tokens[0];
                int age = Integer.valueOf(tokens[1]);
                String id = tokens[2];
                
                Society soc = new Citizen(id, name, age);
                listSociety.add(soc);
            }
            else if (tokens.length == 2) {                  //robot
                String model = tokens[0];
                String id = tokens[1];
                
                Society soc = new Robot(id, model);
                listSociety.add(soc);
            }
            else {
                System.out.println("Invalid Input");
            }
        }
        
        String lastDigitsFakeId = sc.nextLine();
        
        listSociety.stream()
                .forEach(object -> {
                    if (object.getId().endsWith(lastDigitsFakeId)) {
                        System.out.println(object.getId());
                    }
                });
        
        
    }
}
