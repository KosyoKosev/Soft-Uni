import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

public class DistanceOfTheStars {
    public static void main(String[] args) {



        String ligthYearInKm = "9450000000000";

        BigDecimal kmLigthYear = new BigDecimal(ligthYearInKm);

        String EarthToTheEdgeOfTheObservableUniverse = "46500000000";

        BigDecimal kmEarthToUniverse = new BigDecimal(EarthToTheEdgeOfTheObservableUniverse);

        System.out.println(String.format("%1.2e",kmLigthYear.multiply(BigDecimal.valueOf(4.22))));
        System.out.println(String.format("%1.2e",kmLigthYear.multiply(BigDecimal.valueOf(26000))));
        System.out.println(String.format("%1.2e",kmLigthYear.multiply(BigDecimal.valueOf(100000))));
        System.out.println(String.format("%1.2e",kmLigthYear.multiply(kmEarthToUniverse)));

    }
}
