/*
Write a program that reverses the words in a given sentence without changing the punctuation and spaces.
 */
package programmingfundamentals;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReverseWords {

    public static void main(String[] args) {
        String sentence = "The quick. brown fox; jumps' over, the lazy dog /Yes! Really!!!/.";

        String[] word = sentence.split("[\\s+\\]\\.\\,\\(\\)\\;:''\\!\\/]");

        List<String> words = new LinkedList<>(Arrays.asList(word));

        String[] operator = sentence.split("\\w+");

        List<String> operators = new LinkedList<>(Arrays.asList(operator));

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals("")) {
                words.remove(i);
            }
        }

        operators.remove(0); // remove the space before the start of the sentence

        Collections.reverse(words);  //reverse List

        for (int i = 0; i < words.size(); i++) {
            System.out.print(words.get(i) + operators.get(i));
        }

    }
}
