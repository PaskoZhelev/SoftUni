/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaoopadvanced.Ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

/**
 *
 * @author Pasko
 */
public class Main {

    public static void main(String[] args) throws IllegalClassFormatException {

        Scanner sc = new Scanner(System.in);
        String driverName = sc.nextLine();

        Car car = new Ferrari(driverName);
        System.out.println(car.toString());

    }
}
