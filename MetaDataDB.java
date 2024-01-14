import java.sql.*;

public class MetaDataDB {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "postgres")) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("Database Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver Name: " + metaData.getDriverName());
            System.out.println("Driver Version: " + metaData.getDriverVersion());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}