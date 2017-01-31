/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaadvanced;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pasko
 */
public class LittleJohn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
    String input = "";
    int inputNumber = 0;
    int smallArrowsNumber = 0;
    int mediumArrowsNumber = 0;
    int largeArrowsNumber = 0;
    
    String regexSmall = "[^>].*>----->";
    String regexMedium = "[^>].*>>----->";
    String regexLarge = ">>>----->>";
    Pattern patternSmall = Pattern.compile(regexSmall);
    Pattern patternMedium = Pattern.compile(regexMedium);
    Pattern patternLarge = Pattern.compile(regexLarge);
    
    
    while (inputNumber <= 4) {
        input = sc.nextLine();
        
        Matcher matcher = patternLarge.matcher(input);   
        int countLarge = 0; 
        while (matcher.find()) {
            countLarge++;
        }
        
        matcher = patternMedium.matcher(input);
        int countMedium = 0; 
        while (matcher.find()) {
            countMedium++;
        }
    
        matcher = patternSmall.matcher(input);
        int countSmall = 0; 
        while (matcher.find()) {
            countSmall++;
        }
        
        smallArrowsNumber = smallArrowsNumber + countSmall;
        mediumArrowsNumber = mediumArrowsNumber + countMedium;
        largeArrowsNumber = largeArrowsNumber + countLarge;
        
        inputNumber++;
    }
    
        String concatenateCountToString = String.valueOf(smallArrowsNumber) + String.valueOf(mediumArrowsNumber) + String.valueOf(largeArrowsNumber);
        
        String binaryNum = Integer.toBinaryString(Integer.valueOf(concatenateCountToString));
        StringBuilder binaryReversed = new StringBuilder();
        
        for(int i = binaryNum.length() - 1; i >= 0; i--) {
            char a = binaryNum.charAt(i);
            binaryReversed.append(a);
        }
        
        String concatenateBinaryNums = binaryNum + binaryReversed;
        
        int decimalOfBinary = Integer.valueOf(concatenateBinaryNums,2);
        
        System.out.println(decimalOfBinary);
    }
}
