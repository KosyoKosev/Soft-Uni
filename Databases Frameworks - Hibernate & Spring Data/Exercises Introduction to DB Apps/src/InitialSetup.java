import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialSetup {

    public static final String URL = "jdbc:mysql://localhost:3306";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";

    public static void main(String[] args) {

        String createQuery = "CREATE DATABASE minions;";
        String useQuery = "USE minions;";

        String createTableMinionsQuery = "CREATE TABLE minions ( \n" +
                "\tminion_id INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    name VARCHAR(50),\n" +
                "    age INT,\n" +
                "    town_id INT,\n" +
                "    CONSTRAINT fk_minions_towns FOREIGN KEY (town_id)\n" +
                "    REFERENCES towns(town_id)\n" +
                ");";

        String createTableVilliansQuery = "CREATE TABLE villians ( " +
                "villian_id INT PRIMARY KEY AUTO_INCREMENT," +
                "evilness_factor VARCHAR(50), " +
                ");";

        String createTableMinionsVillians = "CREATE TABLE minions_villians ( " +
                "minion_id int, " +
                "villian_id int, " +
                "PRIMARY KEY (minions_id, villian_id)" +
                "FOREIGN KEY (minion_id) " +
                "REFERENCES minions (minion_id) " +
                "FOREIGN KEY (villians_id) " +
                "REFERENCES villians (villians_id) " +
                ");";

        String createTableTownsQuery = "CREATE TABLE towns ( " +
                "town_id int PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR (50), " +
                "country varchar(50));";

        try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(createQuery);
            statement.executeQuery(useQuery);
            statement.executeUpdate(createTableTownsQuery);
            statement.executeUpdate(createTableMinionsQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
