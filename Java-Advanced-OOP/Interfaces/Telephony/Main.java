
package javaoopadvanced.Telephony;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        Smartphone sp = new Smartphone();
        
        String[] numberTokens = input.split("\\s+");
        
        for(String num: numberTokens) {
            sp.callOtherPhones(num);
        }
        
        input = sc.nextLine();
        
        String[] websiteTokens = input.split("\\s+");
        
        for(String website: websiteTokens) {
            sp.browseWWW(website);
        }
        
        
        
        
    }
}
