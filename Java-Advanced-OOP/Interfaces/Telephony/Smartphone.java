package javaoopadvanced.Telephony;

public class Smartphone implements Callable, Browsable {

    @Override
    public void callOtherPhones(String number) {
        
        boolean containsLetter = number.matches(".*[a-zA-Z\\W]+.*");
        
        if(containsLetter) {
            System.out.println("Invalid Number!");
        } else {
            System.out.println("Calling... " + number);
        }
        
    }

    @Override
    public void browseWWW(String website) {
        boolean containsNum = website.matches(".*\\d+.*");

        if (!containsNum) {
            System.out.println("Browsing: " + website + "!");
        } else {
            System.out.println("Invalid URL!");
        }
    }

}
