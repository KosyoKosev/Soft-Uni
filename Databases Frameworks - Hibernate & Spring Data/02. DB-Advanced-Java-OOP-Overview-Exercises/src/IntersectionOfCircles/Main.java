package IntersectionOfCircles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputOne = reader.readLine();

        String inputTwo = reader.readLine();

        String[] splitInputOne = inputOne.split(" ");
        String[] splitInputTwo = inputTwo.split(" ");
        double[] cordinatyCircleOne = new double[splitInputOne.length];
        double[] cordinatyCircleTwo = new double[splitInputTwo.length];

        for (int i = 0; i < splitInputOne.length; i++) {
            cordinatyCircleOne[i] = Double.parseDouble(splitInputOne[i]);
        }
        for (int i = 0; i < splitInputTwo.length; i++) {
            cordinatyCircleTwo[i] = Double.parseDouble(splitInputTwo[i]);
        }
        IntersectionOfCircles.Point pointsCircleOne = new IntersectionOfCircles.Point(cordinatyCircleOne[0], cordinatyCircleOne[1]);
        IntersectionOfCircles.Point pointsCircleTwo = new IntersectionOfCircles.Point(cordinatyCircleTwo[0], cordinatyCircleTwo[1]);

        IntersectionOfCircles.Circle circleOne = new IntersectionOfCircles.Circle(pointsCircleOne, cordinatyCircleOne[2]);
        IntersectionOfCircles.Circle circleTwo = new IntersectionOfCircles.Circle(pointsCircleTwo, cordinatyCircleTwo[2]);

        boolean isIntersect = intersect(circleOne, circleTwo);

        if (isIntersect){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }

    private static boolean intersect(IntersectionOfCircles.Circle circleOne, IntersectionOfCircles.Circle circleTwo) {
        boolean isIntersect = true;
        double distance = Math.sqrt(Math.pow(Math.abs(circleOne.getCenter().getX() - circleTwo.getCenter().getX()), 2) +
                Math.pow(Math.abs(circleOne.getCenter().getY() - circleTwo.getCenter().getY()), 2));

        if (distance > circleOne.getRadius() + circleTwo.getRadius()){
            isIntersect = false;
        }

        return isIntersect;
    }

}
