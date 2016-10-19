/*
You are given two strings, A and B. Find if there is a substring that appears in both A and B.
 */
package programmingfundamentals;

public class CommonStrings {

    public static void main(String[] args) {

        String wordA = "soft";
        String wordB = "softuni";
        boolean commonStrings = false;

        for (int i = 0; i < wordA.length(); i++) {
            if (wordA.charAt(i) == wordB.charAt(i)) {
                commonStrings = true;
                break;
            }
        }

        System.out.println(commonStrings);

    }
}
