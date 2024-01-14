import java.sql.*;
import java.util.Scanner;

public class DMLOperations{
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "postgres")) {
            System.out.println("Connected to the PostgreSQL server.");
            Statement stmt = con.createStatement();
            int choice;
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Select");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        String insertQuery = "INSERT INTO programmer (pname, dob, doj, gender, prof1, prof2, salary) VALUES ('John', '1967-12-01', '1997-01-29', 'M', 'Pascal', 'Oracle', 4100)";
                        int rowsInserted = stmt.executeUpdate(insertQuery);
                        System.out.println("Rows inserted: " + rowsInserted);
                        break;
                    case 2:
                        String updateQuery = "UPDATE programmer SET salary = 3800 WHERE pname = 'Ravi'";
                        int rowsUpdated = stmt.executeUpdate(updateQuery);
                        System.out.println("Rows updated: " + rowsUpdated);
                        break;
                    case 3:
                        String selectQuery = "SELECT * FROM programmer";
                        ResultSet resultSet = stmt.executeQuery(selectQuery);
                        System.out.println("Programmer table:");
                        while (resultSet.next()) {
                            System.out.println("Name: " + resultSet.getString("pname") + ", Salary: " + resultSet.getDouble("salary"));
                        }
                        break;
                    case 4:
                        String deleteQuery = "DELETE FROM programmer WHERE pname='Pavan'";
                        int rowsDeleted = stmt.executeUpdate(deleteQuery);
                        System.out.println("Rows deleted: " + rowsDeleted);
                        break;
                    case 5:
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } while (choice != 5);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
