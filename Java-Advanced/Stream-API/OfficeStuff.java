/*
You are given a sequence of n companies in format |<company> - <amount> - <product>|. Example:
●	|SoftUni - 600 - paper|
●	|Vivacom - 600 - pen|
●	|XS - 20 - chair|
●	|Vivacom - 200 - chair|
●	|SoftUni - 40 - chair|
●	|XS - 40 - chair|
●	|SoftUni - 1 - printer|
Write a program that prints all companies in alphabetical order. For each company
print the product type and their aggregated ordered amounts. Order the products by 
order of appearance. Print the result in the following format: <company>: <product>-<amount>, <product>-<amount>,…
For the orders above the output should be:
●	SoftUni: paper-600, chair-40, printer-1
●	Vivacom: pen-600, chair-200
●	XS: chair-60
Input
The input comes from the console. At the first line the number n stays alone. At the next
n lines, we have n orders in format |<company> - <amount> - <product>|.
The input data will always be valid and in the format described. There is no need to check it explicitly.
Output
Print one line for each company. Company lines should be ordered in alphabetical order.
For each company print the products ordered by this company in order of appearance, along
with the total amount for the given product. Each line should be in format <company>: <product>-<amount>, <product>-<amount>, … <product>-<amount>

 */
package javaadvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class OfficeStuff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        TreeMap<String, Map<String, Integer>> mapOfCompanies = new TreeMap<>();
        
        int n = Integer.valueOf(sc.nextLine());
        String input = "";
        
        for (int i = 0; i < n; i++) {
            
            input = sc.nextLine();
            
            String[] tokens = input.split("\\-");
            
            String company = tokens[0].substring(1, tokens[0].length() - 1).trim();
            int ammount = Integer.valueOf(tokens[1].trim());
            String product = tokens[2].substring(1, tokens[2].length() - 1).trim();
            
            if (!mapOfCompanies.containsKey(company)) {
                Map<String, Integer> mapValues = new LinkedHashMap<>();
                mapValues.put(product, ammount);
                mapOfCompanies.put(company, mapValues);
            }
            else {
                Map<String, Integer> mapValues = mapOfCompanies.get(company);
                if (!mapValues.containsKey(product)) {
                    mapValues.put(product, ammount);
                }
                else {
                    int quantity = mapValues.get(product);
                    quantity = quantity + ammount;
                    mapValues.put(product, quantity);
                }
                mapOfCompanies.put(company, mapValues);
            }
        }
        
        mapOfCompanies.entrySet().stream()
                .sorted((company1, company2) -> company1.getKey().compareTo(company2.getKey()))
                .forEach(firm -> {
                    Map<String, Integer> mapValues = firm.getValue();
                    System.out.printf("%s: ", firm.getKey());
                    StringBuilder sb = new StringBuilder();                  
                    mapValues.entrySet().stream()
                            .forEach(product -> {
                                String productAndAmmount = product.getKey() + "-" + product.getValue() + ", ";
                                sb.append(productAndAmmount);
                                
                            });
                    String products = sb.substring(0, sb.length() - 2);
                    System.out.print(products);
                    System.out.println();
                });
   
    }
}
