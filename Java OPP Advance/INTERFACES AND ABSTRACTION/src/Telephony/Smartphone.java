package Telephony;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callble, Browsing{

    private List<String> phoneNumbers;

    private List<String> urlAddresses;

    public Smartphone(List<String> phoneNumbers, List<String> urlAddresses) {
        this.phoneNumbers = phoneNumbers;
        this.urlAddresses = urlAddresses;
    }

    private boolean isValidPhoneNumbers(String parameter){
        boolean isValid = true;
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(parameter);

        if (matcher.find()){
            isValid = false;
        }
        return isValid;
    }

    private boolean isValidUrlAddress(String parameter){
        boolean isValid = true;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(parameter);

        if (matcher.find()){
            isValid = false;
        }
        return isValid;
    }

    @Override
    public void browsing() {
        for (String urlAddress : urlAddresses) {
            if (isValidUrlAddress(urlAddress)){
                System.out.printf("Browsing: %s!\n", urlAddress);
            }else {
                System.out.println("Invalid URL!");
            }
        }
    }

    @Override
    public void call() {
        for (String phoneNumber : phoneNumbers) {
            if (isValidPhoneNumbers(phoneNumber)){
                System.out.printf("Calling... %s\n", phoneNumber);
            }else {
                System.out.println("Invalid number!");
            }
        }
    }
}
