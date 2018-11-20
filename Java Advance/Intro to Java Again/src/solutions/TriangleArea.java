package solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TriangleArea {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            String[] input = reader.readLine().split("\\s+");
            numbers.add(Integer.parseInt(input[0]));
            numbers.add(Integer.parseInt(input[1]));
        }
        int aX = numbers.get(0);
        int aY = numbers.get(1);
        int bX = numbers.get(2);
        int bY = numbers.get(3);
        int cX = numbers.get(4);
        int cY = numbers.get(5);

        int result = Math.abs(((aX * (bY-cY) + bX * (cY-aY) + cX * (aY-bY))) / 2);
        System.out.println(result);
    }
}
