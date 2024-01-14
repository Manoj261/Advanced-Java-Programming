import java.sql.*;

public class MetadataOnResults {
    public static void main(String[] args) {
        String sql = "SELECT * FROM programmer";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "postgres");
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("Number of columns: " + columnCount);
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column Name: " + metaData.getColumnName(i));
                System.out.println("Column Type: " + metaData.getColumnTypeName(i));
                System.out.println("----------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
