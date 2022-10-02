package module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDb {
//    public  static Connection con;
    public static Connection con = null ;

    public  static ConnectDb db;
    public static Statement stmt;
    private final String jbdcURL = "jdbc:postgresql://localhost:5432/codingSchool";
    private final String username = "postgres";
    private final String password = "youssef1999";

        private ConnectDb(){
            try {
            con = DriverManager.getConnection(jbdcURL,username,password);
        } catch (SQLException e) {
            System.out.println("Error in Connection With a database");
            throw new RuntimeException(e);
        }
        }
    public static  ConnectDb connect(){
        if (db ==null){
            db = new ConnectDb();
        }
        return  db;
    }


}
