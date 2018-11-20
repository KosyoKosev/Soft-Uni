package Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] phoneNumbers = reader.readLine().split(" ");
        String[] urlAddresses = reader.readLine().split(" ");

        for (int i = 0; i < phoneNumbers.length; i++) {
            Smartphone smartphone = new Smartphone();

            if (phoneNumbers[i].isEmpty()){
                continue;
            }
            if (!phoneNumbers[i].matches("^\\d+$")){
                System.out.println("Invalid number!");
            }else {
                smartphone.calling(phoneNumbers[i]);
            }
        }

        for (int i = 0; i < urlAddresses.length; i++) {
            Smartphone smartphone = new Smartphone();

            if (urlAddresses[i].isEmpty()){
                continue;
            }
            if (!urlAddresses[i].matches("^\\D+$")){
                System.out.println("Invalid URL!");
            }else {
                smartphone.browsing(urlAddresses[i]);
            }
        }
    }
}
