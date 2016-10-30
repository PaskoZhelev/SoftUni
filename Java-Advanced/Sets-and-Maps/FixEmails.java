/*
You are given a sequence of strings, each on a new line, unitll you receive “stop” command. First string is a name of a person.
On the second line you receive his email. Your task is to collect their names and emails, and remove emails whose domain ends
with "us" or "uk" (case insensitive). Print:
{name} – > {email} 
 */
package javaadvanced;

import java.util.HashMap;
import java.util.Scanner;


public class FixEmails {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        String name = "";
        String email = "";
        boolean isName = true;

        while (true) {
            String input = sc.nextLine();
            if (input.equals("stop")) {
                break;
            }

            if (isName) {
                name = input;
                isName = false;
            } else {
                email = input;
                String[] emailTokens = email.split("\\.");
                String domainEnds = emailTokens[1];
                if ((!"uk".equals(domainEnds)) && (!"us".equals(domainEnds))) {
                    map.put(name, email);
                }

                isName = true;
            }
        }

        for (String person : map.keySet()) {
            System.out.printf("%s -> %s", person, map.get(person));
            System.out.println();
        }

    }
}
