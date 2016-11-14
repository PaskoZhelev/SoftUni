/*
Heroes III is the best game ever. Everyone loves it and everyone plays it all the time. Stamat is no exclusion to this rule.
His favorite units in the game are all types of dragons – black, red, gold, azure etc… He likes them so much that he gives them 
names and keeps logs of their stats: damage, health and armor. The process of aggregating all the data is quite tedious, so he 
would like to have a program doing it. Since he is no programmer, it’s your task to help him
You need to categorize dragons by their type. For each dragon, identified by name, keep information about his stats. Type is
preserved as in the order of input, but dragons are sorted alphabetically by name. For each type, you should also print the average damage,
health and armor of the dragons. For each dragon, print his own stats. 
There may be missing stats in the input, though. If a stat is missing you should assign it default values. Default values are as follows:
health 250, damage 45, and armor 10. Missing stat will be marked by null.
The input is in the following format {type} {name} {damage} {health} {armor}. Any of the integers may be assigned null value. See the
examples below for better understanding of your task.
If the same dragon is added a second time, the new stats should overwrite the previous ones. Two dragons are considered equal if they
match by both name and type.

 */
package javaadvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class DragonArmy {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final double DAMAGE_DEF = 45;
        final double HEALTH_DEF = 250;
        final double ARMOR_DEF = 10;
        LinkedHashMap<String, TreeMap<String, double[]>> dragons = new LinkedHashMap<>();
        TreeMap<String, double[]> dragonNames;

        int n = Integer.valueOf(sc.nextLine());

        if (n > 100) {
            throw new IllegalArgumentException("N must be in the range from 1 to 100");
        }

        String input = "";
        for (int i = 0; i < n; i++) {
            input = sc.nextLine();
            String[] tokens = input.split("\\s");

            String type = tokens[0];
            String name = tokens[1];
            double damage = tokens[2].equals("null") ? DAMAGE_DEF : Double.valueOf(tokens[2]);
            double health = tokens[3].equals("null") ? HEALTH_DEF : Double.valueOf(tokens[3]);
            double armor = tokens[4].equals("null") ? ARMOR_DEF : Double.valueOf(tokens[4]);

            if (!dragons.containsKey(type)) {
                dragonNames = new TreeMap<>();
                dragonNames.put(name, new double[3]);
                dragonNames.get(name)[0] = damage;
                dragonNames.get(name)[1] = health;
                dragonNames.get(name)[2] = armor;

                dragons.put(type, dragonNames);
            } else {
                dragonNames = dragons.get(type);
                dragonNames.put(name, new double[3]);
                dragonNames.get(name)[0] = damage;
                dragonNames.get(name)[1] = health;
                dragonNames.get(name)[2] = armor;

                dragons.put(type, dragonNames);

            }
        }

        dragons.entrySet().stream()
                .forEach(dragonType -> {
                    double[] avgStats = calcAverage(dragonType.getValue());
                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n", dragonType.getKey(), avgStats[0], avgStats[1], avgStats[2]);

                    dragonType.getValue().entrySet().stream()
                            .forEach(dragonName -> {
                                double[] stats = dragonName.getValue();
                                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n", dragonName.getKey(), stats[0], stats[1], stats[2]);
                            });
                });

    }

    public static double[] calcAverage(TreeMap<String, double[]> map) {
        double totalNames = map.size();
        double totalDamage = 0;
        double totalHealth = 0;
        double totalArmor = 0;

        for (Map.Entry<String, double[]> entry : map.entrySet()) {
            totalDamage += entry.getValue()[0];
            totalHealth += entry.getValue()[1];
            totalArmor += entry.getValue()[2];
        }
        double[] averageStats = new double[3];

        averageStats[0] = totalDamage / totalNames;
        averageStats[1] = totalHealth / totalNames;
        averageStats[2] = totalArmor / totalNames;

        return averageStats;
    }
}
