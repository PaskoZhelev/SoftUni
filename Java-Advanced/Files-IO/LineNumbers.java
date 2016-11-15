/*
Write a program that reads a text file and inserts line numbers in front of each of its lines. The result should be written to another text file. 
 */
package javaadvanced;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class LineNumbers {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fileInput = new File("C:\\Users\\Pasko\\Desktop\\text.txt");
        File fileOutput = new File("C:\\Users\\Pasko\\Desktop\\output.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(fileInput));
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileOutput, false))) {

            String readLine = null;
            int numLine = 1;

            while ((readLine = br.readLine()) != null) {
                bw.write(numLine + ". " + readLine);
                bw.newLine();
                numLine++;
            }

        } catch (Exception e) {
        }

    }
}
