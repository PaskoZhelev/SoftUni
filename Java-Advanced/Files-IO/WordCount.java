/*
Write a program that reads a list of words from the file words.txt and finds how many
times each of the words is contained in another file text.txt. Matching should be case-insensitive.
Write the results in file results.txt. Sort the words by frequency in descending order. 

 */
package javaadvanced;

import com.sun.org.apache.xml.internal.security.c14n.helper.C14nHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SortedMap;


public class WordCount {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File words = new File("C:\\Users\\Pasko\\Desktop\\words1.txt");
        File text = new File("C:\\Users\\Pasko\\Desktop\\text1.txt");
        File outputWords = new File("C:\\Users\\Pasko\\Desktop\\countWords.txt");

        List<String> wordList = new ArrayList<>();
        String textInput = "";

        try (BufferedReader wordReader = new BufferedReader(new FileReader(words));
                BufferedReader textReader = new BufferedReader(new FileReader(text));
                BufferedWriter wordCountWriter = new BufferedWriter(new FileWriter(outputWords, false))) {

            String readLineWords = null;

            while ((readLineWords = wordReader.readLine()) != null) {
                String[] tokens = readLineWords.split("\\s");
                for (String word : tokens) {
                    wordList.add(word);         //adding every word from the line to the list of words
                }
            }

            String readLineText = null;
            while ((readLineText = textReader.readLine()) != null) {
                textInput = textInput + "\n" + readLineText;
            }

            String[] wordTokens = textInput.split("[\\s\\W]");
            List<String> listWordsText = new ArrayList<>();
            for (String ex : wordTokens) {
                if (!ex.equals("")) {
                    listWordsText.add(ex);
                }
            }

            LinkedHashMap<String, Integer> wordOccurence = new LinkedHashMap<>();
            for (String wrd : wordList) {
                int occurr = 0;
                for (String wrdText : listWordsText) {
                    if (wrd.equals(wrdText.toLowerCase())) {         //to ignore case sensitivity
                        occurr++;
                    }
                }
                wordOccurence.put(wrd, occurr);
            }

            wordOccurence.entrySet().stream()
                    .sorted((c1, c2) -> wordOccurence.get(c2.getKey()).compareTo(wordOccurence.get(c1.getKey())))
                    .forEach(word -> {
                        String wordFrequency = String.format("%s - %d%n", word.getKey(), word.getValue());

                        try {
                            wordCountWriter.write(wordFrequency);
                        } catch (Exception e) {
                        }

                    });

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
