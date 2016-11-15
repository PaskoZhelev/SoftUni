/*
Write a program that reads a text file and writes its every odd line in another file. Line numbers starts from 0. 
 */
package javaadvanced;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class OddLines {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fileInput = new File("C:\\Users\\Pasko\\Desktop\\text.txt");
        File fileOutput = new File("C:\\Users\\Pasko\\Desktop\\output.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(fileInput));
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileOutput, false))) {
            String readLine = null;
            int numLine = 0;

            while ((readLine = br.readLine()) != null) {
                if (numLine % 2 != 0) {
                    bw.write(readLine);
                    bw.newLine();
                }
                numLine++;
            }

        } catch (Exception e) {
        }

    }

}
