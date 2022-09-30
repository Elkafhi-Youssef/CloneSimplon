import java.sql.Connection;

public class ConnectDb {
    public  static Connection con;
    String jbdcURL = "jdbc:postgresql://localhost:5432/codingSchool";
        String username = "postgres";
        String password = "youssef1999";
//        try {
//            Connection connection = DriverManager.getConnection(jbdcURL,username,password);
//            System.out.println("Connect to postgresql");
//
//        } catch (SQLException e) {
//            System.out.println("Error in Connection With a database");
//            throw new RuntimeException(e);
//        }

}
