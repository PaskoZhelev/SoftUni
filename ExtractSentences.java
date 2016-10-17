/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programmingfundamentals;

import java.util.Scanner;

/**
 *
 * @author Pasko
 */
public class ExtractSentences {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String keyword = sc.nextLine();
        String input = sc.nextLine();

        String[] sentence = input.split("[\\!.?]");

        for (int i = 0; i < sentence.length; i++) {
            String[] word = sentence[i].split("[\\s,]");    //split the sentence into words
            for (int j = 0; j < word.length; j++) {
                if (word[j].matches(keyword)) {
                    System.out.println(sentence[i]);
                }
            }
        }
    }
}
