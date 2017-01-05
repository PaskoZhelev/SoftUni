/*
Extract and print the Marks of the students that enrolled in 2014 or 2015 
(the students from 2014 have 14 as their 5-th and 6-th digit in the FacultyNumber, those from 2015 have 15).
 */
package javaadvanced;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentsEnrolled {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<Integer>> listStudents = new LinkedHashMap<>();

        String input = "";

        while (!(input = sc.nextLine()).equals("END")) {
            String[] tokens = input.split("\\s+");
            String facultyNumber = tokens[0];
            List<Integer> grades = new ArrayList<>();

            for (int i = 1; i < tokens.length; i++) {

                int num = Integer.valueOf(tokens[i]);
                grades.add(num);
            }

            listStudents.put(facultyNumber, grades);
        }

        listStudents.entrySet().stream()
                .filter(entry -> entry.getKey().endsWith("14") || entry.getKey().endsWith("15"))
                .forEach(entry -> {
                    List<Integer> list = entry.getValue();

                    list.stream()
                            .forEach(num -> System.out.printf("%d ", num));
                    System.out.println();
                });

    }
}
