/*
Create a class Person. It should consists of properties : name and group (String, Integer).
Write a program that extracts all persons (students), grouped by GroupName and then prints
them on the console. Print all group names along with the students in each group. Use the
group by Stream operations. You will be given an input on the console.

Output format : {group} - {name1}, {name2}, {name3}, ...

 */
package javaadvanced;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class GroupByGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> people = new LinkedList<>();
        String input = "";

        while (!(input = sc.nextLine()).equals("END")) {
            String[] tokens = input.split("\\s+");

            String name = tokens[0] + " " + tokens[1];
            int group = Integer.valueOf(tokens[2]);
            Person person = new Person(name, group);

            people.add(person);

        }

        Map<Integer, List<Person>> peopleByGroup
                = people.stream()
                .collect(Collectors.groupingBy(Person::getGroup));

        peopleByGroup.entrySet().stream()
                .forEach(entry -> {
                    List<Person> listPersons = entry.getValue();

                    System.out.printf("%s - ", entry.getKey());
                    List<String> names = new LinkedList<>();

                    for (Person pers : listPersons) {
                        String name = pers.getName();
                        names.add(name);
                    }

                    String fullList = String.join(", ", names);

                    System.out.println(fullList);

                });
    }
}

class Person {

    private String name;
    private int group;

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(int group) {
        this.group = group;
    }

}

