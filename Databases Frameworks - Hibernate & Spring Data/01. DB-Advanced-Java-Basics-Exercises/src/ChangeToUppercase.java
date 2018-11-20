package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChangeToUppercase {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        List<String> result = new ArrayList<>();
        String firstUpper = "<upcase>";
        String secondUpper = "</upcase>";
        boolean isIn = false;

        for (int i = 0; i < input.length; i++) {
            result.add(input[i]);
        }

        for (int i = 0; i < input.length; i++) {

            if (input[i].contains("<upcase>") && input[i].contains("</upcase>")){
                result.remove(input[i]);
                String upper1 = input[i].substring(firstUpper.length()).replace("</upcase>", "").toUpperCase();
                result.add(i, upper1);
                continue;
            }
            if (input[i].contains("<upcase>")){

                result.remove(input[i]);
                String upper = input[i].replace("<upcase>", "").toUpperCase();
                result.add(i, upper);
                isIn = true;
            }else if (isIn && (!input[i].contains("</upcase>"))){
                result.remove(input[i]);
                String upper = input[i].toUpperCase();
                result.add(i, upper);
            }

            if (input[i].contains("</upcase>")){
                result.remove(input[i]);
                String text = input[i].replace("</upcase>", "").toUpperCase();
                result.add(i, text);
                isIn = false;
            }
        }

        String change = String.join(" ", result);
        System.out.println(change);
    }
}
