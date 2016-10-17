/*
We are given a text. Write a program that modifies the casing of letters to uppercase 
at all places in the text surrounded by <upcase> and </upcase> tags. Tags cannot be nested.
 */
package programmingfundamentals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class ChangeToUpperCase {
    
     public static void main(String[] args) {

        String input = "Welcome to the <upcase>Software University</upcase>."
                + " Learn <upcase>computer programming</upcase> and start a <upcase>job</upcase> in a software company.";

        String[] sentence = input.split("(?<=</upcase>)");   // LookAhead delimeter; divide the text into parts ending with </upcase>
        
        List<String> sentences = new LinkedList<>(Arrays.asList(sentence));
       
        
       for (int i = 0; i < sentences.size(); i++) {
                    
            int indexA = sentences.get(i).indexOf("<upcase>");
            int indexB = sentences.get(i).indexOf("</upcase>");
            
            if (indexA == -1) {
                System.out.println(sentences.get(i));
                continue;
            }
            
            String textOutside = sentences.get(i).substring(0, indexA); //text outside the tags
           String textInside = sentences.get(i).substring(indexA + 8, indexB);  //text between the tags
            
           String fullText = textOutside + textInside.toUpperCase();
           
           System.out.print(fullText);
            
        } 

    }

    
}
