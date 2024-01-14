import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","postgres");
        PreparedStatement stmt = con.prepareStatement("insert into programmer values(?,?,?,?,?,?,?)");
        stmt.setString(1,"Bablu");
        stmt.setDate(2,new Date(60,12,13));
        stmt.setDate(3,new Date(90,12,13));
        stmt.setString(4,"M");
        stmt.setString(5,"Assembly");
        stmt.setString(6,"Dbase");
        stmt.setFloat(7,3100);
        int cnt = stmt.executeUpdate();
        if(cnt!=0)
            System.out.println("Successfully inserted");
        else
            System.out.println("Not inserted");
    }
}
