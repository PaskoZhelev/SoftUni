package javaoopadvanced.MilitaryElite;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javaoopadvanced.MilitaryElite.interfaces.Mission;
import javaoopadvanced.MilitaryElite.interfaces.Private;
import javaoopadvanced.MilitaryElite.interfaces.Repair;
import javaoopadvanced.MilitaryElite.interfaces.Soldier;
import javaoopadvanced.MilitaryElite.models.CommandoImpl;
import javaoopadvanced.MilitaryElite.models.EngineerImpl;
import javaoopadvanced.MilitaryElite.models.LeutenantGeneralImpl;
import javaoopadvanced.MilitaryElite.models.MissionImpl;
import javaoopadvanced.MilitaryElite.models.PrivateImpl;
import javaoopadvanced.MilitaryElite.models.RepairImpl;
import javaoopadvanced.MilitaryElite.models.SpyImpl;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "";
        Map<Integer, Soldier> soldiers = new LinkedHashMap<>();

        while (!(input = sc.nextLine()).equals("End")) {
            String[] tokens = input.split("\\s+");

            int id = Integer.valueOf(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (tokens[0]) {
                case "Private":
                    double salaryPrivate = Double.valueOf(tokens[4]);
                    Soldier soldierPrivate = new PrivateImpl(id, firstName, lastName, salaryPrivate);
                    soldiers.put(soldierPrivate.getId(), soldierPrivate);
                    break;
                case "LeutenantGeneral":
                    double salaryLeutenant = Double.valueOf(tokens[4]);
                    List<Private> privates = new LinkedList<>();
                    for (int i = 5; i < tokens.length; i++) {
                        int idPrivate = Integer.valueOf(tokens[i]);
                        Private prv = (Private) soldiers.get(idPrivate);
                        privates.add(prv);
                    }
                    Soldier soldierLeutenant = new LeutenantGeneralImpl(id, firstName, lastName, salaryLeutenant, privates);
                    soldiers.put(soldierLeutenant.getId(), soldierLeutenant);
                    break;
                case "Engineer":
                    double salaryEngineer = Double.valueOf(tokens[4]);
                    String corpsEngineer = tokens[5];
                    List<Repair> repairs = new LinkedList<>();
                    for (int i = 6; i < tokens.length - 1; i += 2) {
                        try {
                            String repairPart = tokens[i];
                            int hoursToRepair = Integer.valueOf(tokens[i + 1]);
                            Repair currentRepair = new RepairImpl(repairPart, hoursToRepair);
                            repairs.add(currentRepair);
                        } catch (IllegalArgumentException e) {
                            
                        }

                    }
                    Soldier soldierEngineer = new EngineerImpl(id, firstName, lastName, salaryEngineer, corpsEngineer, repairs);
                    soldiers.put(soldierEngineer.getId(), soldierEngineer);
                    break;
                case "Commando":
                    double salaryCommando = Double.valueOf(tokens[4]);
                    String corpsCommando = tokens[5];
                    List<Mission> missions = new LinkedList<>();
                    for (int i = 6; i < tokens.length - 1; i += 2) {
                        try {
                            Mission currentMission = new MissionImpl(tokens[i], tokens[i + 1]);
                            missions.add(currentMission);
                        } catch (IllegalArgumentException e) {

                        }

                    }
                    try {
                        Soldier soldierCommando = new CommandoImpl(id, firstName, lastName, salaryCommando, corpsCommando, missions);
                        soldiers.put(soldierCommando.getId(), soldierCommando);
                    } catch (IllegalArgumentException e) {
                        
                    }
                    break;
                case "Spy":
                    String codeNumberSpy = tokens[4];
                    Soldier soldierSpy = new SpyImpl(id, firstName, lastName, codeNumberSpy);
                    soldiers.put(soldierSpy.getId(), soldierSpy);
                    break;
            }
        }
        
        soldiers.entrySet().stream()
                .forEach(sldr -> System.out.println(sldr.getValue().toString()));
    }
}
