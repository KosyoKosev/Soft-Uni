import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);




        int aX = Integer.parseInt(sc.next());
        int aY = Integer.parseInt(sc.next());
        int bX = Integer.parseInt(sc.next());
        int bY = Integer.parseInt(sc.next());
        int cX = Integer.parseInt(sc.next());
        int cY = Integer.parseInt(sc.next());

        int result = Math.abs(((aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY))) / 2);

        System.out.println(result);
    }
}
