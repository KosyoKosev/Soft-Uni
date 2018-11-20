package AdvertisementMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());

        String[] phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.",
        "Best product of its category.", "Exceptional product.", "I can’t live without this product."};

        String[] events = new String[]{"Now I feel good.", "I have succeeded with this product.",
        "Makes miracles. I am happy of the results!",
        "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};

        String[] author = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random rnd = new Random();



        for (int i = 0; i < input; i++) {
            int phrasesRandom = rnd.nextInt(phrases.length );
            int eventsRandom = rnd.nextInt(events.length );
            int authorRandom = rnd.nextInt(author.length );
            int citiesRandom = rnd.nextInt(cities.length );
            System.out.printf("%s%s%s - %s\n", phrases[phrasesRandom], events[eventsRandom], author[authorRandom], cities[citiesRandom]);
        }

    }
}
