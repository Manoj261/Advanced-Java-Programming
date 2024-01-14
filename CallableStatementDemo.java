import java.sql.*;

public class CallableStatementDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "postgres");
        String sql_string = "insert into programmer values(?,?,?,?,?,?,?)";
        CallableStatement cs = con.prepareCall(sql_string);
        cs.setString(1,"Ravi");
        cs.setDate(2,new Date(63,3,13));
        cs.setDate(3,new Date(93,7,13));
        cs.setString(4,"M");
        cs.setString(5,"C");
        cs.setString(6,"Assembly");
        cs.setFloat(7,4100);
        cs.execute();
        System.out.println("Successfully Inserted");
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("select * from programmer where pname='Ravi';");
        int cnt=rs.getMetaData().getColumnCount();
        int i=1;
        System.out.println("Inserted Details are:");
        while(rs.next())
        {
            while(i<=cnt){
                System.out.println(rs.getObject(i++));
            }
        }
    }
}
