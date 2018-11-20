import java.util.Scanner;

public class TrickyStrings {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String delimiter = sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        String text = "";

        for (int i = 0;i < n;i++){

            String inputText = sc.nextLine();

            if (i < n - 1){
                text += inputText + delimiter;
            }else {
                text += inputText;
            }
        }

        System.out.println(text);
    }
}
