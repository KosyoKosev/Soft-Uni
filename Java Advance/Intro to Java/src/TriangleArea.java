import javafx.scene.input.DataFormat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#.##");

        long x1 = Long.parseLong(sc.next());
        long y1 = Long.parseLong(sc.next());
        long x2 = Long.parseLong(sc.next());
        long y2 = Long.parseLong(sc.next());
        long x3 = Long.parseLong(sc.next());
        long y3 = Long.parseLong(sc.next());


        long triangleArea = (Math.abs((x1 * (y2 -y3)) + (x2 * (y3 - y1)) + (x3 * (y1 - y2))) / 2);

        System.out.println(df.format(triangleArea));
    }
}
