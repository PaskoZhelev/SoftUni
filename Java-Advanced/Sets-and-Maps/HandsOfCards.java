/*
You are given a sequence of people and for every person what cards he draws from the deck. The input will be separate lines in the format:
{personName}: {PT, PT, PT,… PT}
Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A) is the power of the card and T (S, H, D, C) is the type. The input ends when a "JOKER" is drawn.
The name can contain any ASCII symbol except ':'. The input will always be valid and in the format described, there is no need to check it.
A single person cannot have more than one card with the same power and type, if he draws such a card he discards it. The people are playing
with multiple decks. Each card has a value that is calculated by the power multiplied by the type. Powers 2 to 10 have the same value
and J to A are 11 to 14. Types are mapped to multipliers the following way (S -> 4, H-> 3, D -> 2, C -> 1).
Finally print out the total value each player has in his hand in the format:
{personName}: {value}

 */
package javaadvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HandsOfCards {
   public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, List<String>> mapPlayers = new HashMap<>();
        List<String> listCards;

        HashMap<String, Integer> mapPowers = new HashMap<>();
        mapPowers.put("2", 2);
        mapPowers.put("3", 3);
        mapPowers.put("4", 4);
        mapPowers.put("5", 5);
        mapPowers.put("6", 6);
        mapPowers.put("7", 7);
        mapPowers.put("8", 8);
        mapPowers.put("9", 9);
        mapPowers.put("10", 10);
        mapPowers.put("J", 11);
        mapPowers.put("Q", 12);
        mapPowers.put("K", 13);
        mapPowers.put("A", 14);
        HashMap<String, Integer> mapTypes = new HashMap<>();
        mapTypes.put("C", 1);
        mapTypes.put("D", 2);
        mapTypes.put("H", 3);
        mapTypes.put("S", 4);

        while (true) {
            String input = sc.nextLine();

            if (input.equals("JOKER")) {
                break;
            }

            String[] nameToken = input.split("\\:");    //divide the name
            String name = nameToken[0];

            int indexOfColon = input.indexOf(":");
            input = input.substring(indexOfColon + 1);     //delete the name part + the colon sign (:)
            String[] cardTokens = input.split("\\,+");      //array of the cards

            if (mapPlayers.containsKey(name)) {
                listCards = new ArrayList<>(mapPlayers.get(name));
                for (String card : cardTokens) {
                    if (!listCards.contains(card)) {
                        listCards.add(card);
                    }
                }
                mapPlayers.put(name, listCards);
            } else {
                listCards = new ArrayList<>(Arrays.asList(cardTokens));
                mapPlayers.put(name, listCards);
            }
        }

        for (String player : mapPlayers.keySet()) {
            List<String> list = mapPlayers.get(player);
            int value = 0;
            for (int i = 0; i < list.size(); i++) {
                String card = list.get(i);
                String power = card.substring(1, card.length() - 1).trim();     //getting the power and trimming any whitespaces
                String type = card.substring(card.length() - 1);

                value += (mapPowers.get(power) * mapTypes.get(type));
            }
            System.out.println(player + ": " + value);
        }

    }
}
