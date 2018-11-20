package BookLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Library library = new Library();

        for (int i = 0; i < n; i++) {
            String text = reader.readLine();

            String[] split = text.split(" ");
            String title = split[0];
            String author = split[1];
            String publisher = split[2];
            String releaseDate = split[3];
            String isbn = split[4];
            double price = Double.parseDouble(split[5]);

            Book book = new Book(title,author,publisher,releaseDate,isbn,price);

            library.addBook(book);
        }

        library.getBooks().stream().collect(Collectors.groupingBy(Book::getAuthor, Collectors.summingDouble(Book::getPrice)))
                .entrySet().stream().sorted((a,b) -> {
            int result = Double.compare(b.getValue(),a.getValue());
            if (result == 0){
                result = a.getKey().compareTo(b.getKey());
            }
            return result;
        }).forEach(a ->
                System.out.printf("%s -> %.2f\n", a.getKey(), a.getValue())
        );
    }
}
