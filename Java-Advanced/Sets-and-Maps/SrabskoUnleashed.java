/*
Admit it – the СРЪБСКО is your favorite sort of music. You never miss a concert and you have become quite the geek concerning
everything involved with СРЪБСКО. You can’t decide between all the singers you know who your favorite one is. One way to find
out is to keep a statistics of how much money their concerts make. Write a program that does all the boring calculations for you.
On each input line you’ll be given data in format: "singer @venue ticketsPrice ticketsCount". There will be no redundant whitespaces
anywhere in the input. Aggregate the data by venue and by singer. For each venue, print the singer and the total amount of
money his/her concerts have made on a separate line. Venues should be kept in the same order they were entered, the singers
should be sorted by how much money they have made in descending order. If two singers have made the same amount of money,
keep them in the order in which they were entered. 
Keep in mind that if a line is in incorrect format, it should be skipped and its data should not be added to the output.
Each of the four tokens must be separated by a space, everything else is invalid. The venue should be denoted with @ in front of
it, such as @Sunny Beach

SKIP THOSE: Ceca@Belgrade125 12378, Ceca @Belgrade12312 123

The singer and town name may consist of one to three words. 

 */
package javaadvanced;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;


public class SrabskoUnleashed {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> mapMain = new LinkedHashMap<>();   //map of (venue, mapSingers)
        LinkedHashMap<String, Integer> mapSingers;                                               //map of (Singer, totalMoney)
        String input = "";
        String singer = "";
        String venue = "";
        int ticketsPrice = 0;
        int ticketsCount = 0;

        while (!input.equals("End")) {
            input = sc.nextLine();
            String pattern = "\\w+( \\w+)? @\\w+( \\w+)? \\d+ \\d+";
            boolean matches = Pattern.matches(pattern, input);

            if (matches) {                              //if the pattern is correct
                String[] tokens = input.split("@");
                singer = tokens[0].trim();
                String[] splitted = tokens[1].split("\\s");

                switch (splitted.length) {  //in order to find if venue's name consists of two words
                    case 3:
                        venue = splitted[0];
                        ticketsPrice = Integer.valueOf(splitted[1]);
                        ticketsCount = Integer.valueOf(splitted[2]);
                        break;
                    case 4:
                        venue = splitted[0] + " " + splitted[1];
                        ticketsPrice = Integer.valueOf(splitted[2]);
                        ticketsCount = Integer.valueOf(splitted[3]);
                        break;
                }

                if (!mapMain.containsKey(venue)) {
                    mapSingers = new LinkedHashMap<>();
                    int totalMoney = ticketsPrice * ticketsCount;
                    mapSingers.put(singer, totalMoney);
                    mapMain.put(venue, mapSingers);
                } else {
                    mapSingers = mapMain.get(venue);
                    if (!mapSingers.containsKey(singer)) {
                        int totalMoney = ticketsPrice * ticketsCount;
                        mapSingers.put(singer, totalMoney);
                        mapMain.put(venue, mapSingers);
                    } else {
                        int currentMoney = mapSingers.get(singer);
                        int totalMoney = (ticketsPrice * ticketsCount) + currentMoney;
                        mapSingers.put(singer, totalMoney);
                        mapMain.put(venue, mapSingers);
                    }
                }
            }

        }

        mapMain.entrySet().stream()
                .forEach(place -> {
                    System.out.format("%s\n", place.getKey());

                    place.getValue().entrySet().stream()
                            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                            .forEach(person -> {
                                System.out.format("#  %s -> %d\n", person.getKey(), person.getValue());
                            });
                });

    }
}
