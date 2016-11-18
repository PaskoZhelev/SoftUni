/*
Write a program that reads the contents of two text files and merges them together into a third one.
 */
package javaadvanced;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MergeFiles {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File fileOne = new File("C:\\Users\\Pasko\\Desktop\\fileOne.txt");
        File fileTwo = new File("C:\\Users\\Pasko\\Desktop\\fileTwo.txt");
        File output = new File("C:\\Users\\Pasko\\Desktop\\output.txt");
        
        try (BufferedReader brFileOne = new BufferedReader(new FileReader(fileOne));
        BufferedReader brFileTwo = new BufferedReader(new FileReader(fileTwo));
                BufferedWriter bw = new BufferedWriter(new FileWriter(output,false))) {
            String readLineOne = "";
            String readLineTwo = "";
            while(((readLineOne = brFileOne.readLine()) != null) & ((readLineTwo = brFileTwo.readLine()) != null)) {
                bw.write(readLineOne);
                bw.newLine();
                bw.write(readLineTwo);
                bw.newLine();
            }
            
        } catch (Exception e) {
                System.out.println(e);
        }
    }
    
}
