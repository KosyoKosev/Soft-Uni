

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DHARMASupplies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern forFood = Pattern.compile("(?<firstTag>\\[#[0-9]+)(?<body>[\\w\\s]+)(?<secondTag>#[0-9]+\\])");
        Pattern forDrink = Pattern.compile("(?<firstTag>\\[#[a-z]+)(?<body>[\\w\\s]+)(?<secondTag>#[a-z]+\\])");
        int counterCrates = 0;
        int counterInputs = 0;
        List<String> inputs = new LinkedList<>();

        while (true){
            String input = reader.readLine();

            if ("Collect".equals(input)){
                break;
            }
            counterInputs++;
            inputs.add(input);

            Matcher matcherForFood = forFood.matcher(input);
            while (matcherForFood.find()){
                counterCrates++;
            }
            Matcher matcherForDrink = forDrink.matcher(input);
            while (matcherForDrink.find()){
                counterCrates++;
            }
        }

        int n = counterCrates / counterInputs;
        for (String input : inputs) {
            Matcher matcherFood = forFood.matcher(input);
            while (matcherFood.find()){
                String matchFirstTag = matcherFood.group("firstTag");
                String matchSecondTag = matcherFood.group("secondTag");
                if (isValidCate(matchFirstTag, matchSecondTag, n)){

                }
            }
            Matcher matcherDrink = forDrink.matcher(input);
            while (matcherDrink.find()){
                String matchFirstTag = matcherFood.group("firstTag");
                String matchSecondTag = matcherFood.group("secondTag");
                if (isValidCate(matchFirstTag, matchSecondTag, n)){

                }
            }
        }

    }

    private static Boolean isValidCate(String firstTag, String secondTag, int n) {
        boolean isValid = false;
        String bodyFirstTag = firstTag.substring(1, firstTag.length());
        String bodySecondTag = secondTag.substring(0,(secondTag.length() - 1));
        if (bodyFirstTag.equals(bodySecondTag) && (bodyFirstTag.length() - 1) == n){
            isValid = true;
        }
        return isValid;
    }
}
