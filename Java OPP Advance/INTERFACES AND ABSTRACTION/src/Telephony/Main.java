package Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> numbers = new LinkedList<>();
        List<String> urlAddresses = new LinkedList<>();

        String[] lineOfNumbers = reader.readLine().split(" ");
        String[] lineOfUrlAddresses = reader.readLine().split(" ");

        for (String number : lineOfNumbers) {
            numbers.add(number);
        }

        for (String urlAddress : lineOfUrlAddresses) {
            urlAddresses.add(urlAddress);
        }

        Smartphone smartphone = new Smartphone(numbers, urlAddresses);

        smartphone.call();
        smartphone.browsing();
    }
}
