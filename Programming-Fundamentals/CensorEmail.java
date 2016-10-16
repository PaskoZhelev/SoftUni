/*
 * You have some text that contains your email address. You’re sick of spammers, so you want to hide it. 
You decide to censor your email: to replace all characters in it with asterisks ('*') except the domain.
Assume your email address will always be in format [username]@[domain]. 
You need to replace the username with asterisks of equal number of letters and keep the domain unchanged.

 */
package programmingfundamentals;

/**
 *
 * @author Pasko
 */
public class CensorEmail {

    public static void main(String[] args) {
        String email = "pesho.peshev@abv.bg";

        String[] splitted = email.split("@");

        String username = splitted[0];
        String address = splitted[1];

        username = username.replaceAll(".", "*");

        email = username + "@" + address;

        System.out.println(email);
    }
}
