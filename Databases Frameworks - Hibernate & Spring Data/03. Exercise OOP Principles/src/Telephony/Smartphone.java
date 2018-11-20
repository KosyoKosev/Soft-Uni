package Telephony;

public class Smartphone implements Calling, Browsing{
    String phoneNumber;
    String urlAddress;

    public Smartphone() {
    }

    @Override
    public void calling(String phoneNumber) {
        System.out.printf("Calling... %s\n", phoneNumber);
        return;
    }

    @Override
    public void browsing(String urlAddress) {
        System.out.printf("Browsing: %s!\n", urlAddress);
        return;
    }
}
