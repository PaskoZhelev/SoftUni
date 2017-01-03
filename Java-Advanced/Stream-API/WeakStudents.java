/*
Write a similar program to the previous one to extract the students with at least 2 marks under or equal to "3". Use a Stream.
 */
package javaadvanced;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WeakStudents {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = "";
        Map<String, List<Integer>> persons = new LinkedHashMap<>();

        while (!(input = sc.nextLine()).equals("END")) {
            String[] tokens = input.split("\\s+");
            List<Integer> grades = new ArrayList<>();

            String name = tokens[0] + " " + tokens[1];

            for (String a : tokens) {
                try {
                    int num = Integer.valueOf(a);
                    grades.add(num);
                } catch (Exception e) {
                }
            }

            persons.put(name, grades);
        }

        List<String> weakStudents = new LinkedList<>();

        persons.entrySet().stream()
                .forEach(entry -> {

                    List<Integer> listGrades = entry.getValue();

                    listGrades = listGrades.stream()
                            .filter(num -> num <= 3)
                            .collect(Collectors.toList());

                    if (listGrades.size() >= 2) {
                        weakStudents.add(entry.getKey());
                    }
                });

        weakStudents.stream()
                .forEach(System.out::println);

    }
}
