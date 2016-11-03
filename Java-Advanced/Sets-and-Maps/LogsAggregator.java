/*
You are given a sequence of access logs in format <IP> <user> <duration>. For example:
•	192.168.0.11 peter 33
•	10.10.17.33 alex 12
•	10.10.17.35 peter 30
•	10.10.17.34 peter 120
•	10.10.17.34 peter 120
•	212.50.118.81 alex 46
•	212.50.118.81 alex 4
Write a program to aggregate the logs data and print for each user the total duration of his sessions
and a list of unique IP addresses in format "<user>: <duration> [<IP1>, <IP2>, …]". Order the users alphabetically.
Order the IPs alphabetically. In our example, the output should be the following:
•	alex: 62 [10.10.17.33, 212.50.118.81]
•	peter: 303 [10.10.17.34, 10.10.17.35, 192.168.0.11]

 */
package javaadvanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;


public class LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        TreeMap<String, Integer> mapNameDuration = new TreeMap<>();
        Map<String, TreeSet<String>> mapIps = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();

            String[] wordTokens = input.split("\\s");
            String ipAddress = wordTokens[0];
            String name = wordTokens[1];
            int duration = Integer.valueOf(wordTokens[2]);

            if (!mapNameDuration.containsKey(name)) {
                mapNameDuration.put(name, duration);
                TreeSet<String> set = new TreeSet<>();              //create a set for the IPs
                set.add(ipAddress);
                mapIps.put(name, set);
            } else {
                int currentDuration = mapNameDuration.get(name);
                currentDuration += duration;                        //add the duration to the current duration
                mapNameDuration.put(name, currentDuration);

                TreeSet<String> set = mapIps.get(name);         //get the set of IPs used by this user
                set.add(ipAddress);
                mapIps.put(name, set);
            }
        }

        for (String name : mapNameDuration.keySet()) {                      //print the results
            System.out.printf("%s: %d ", name, mapNameDuration.get(name));           
            TreeSet<String> set = mapIps.get(name);
            System.out.println(set);                       
        }

    }
}
