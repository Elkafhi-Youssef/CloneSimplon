import global.GloabState;
import module.ConnectDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Auth {

    public String email;
    public String password;
    static Connection con = ConnectDb.con;



    public static boolean login(String email,String password){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from admin where email = ? and password = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        }catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }
    public static int loginFormateur(String email,String password){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from formateurs where email = ? and password = ?");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_formateur");
                GloabState.idLoginUser = id;

            }
            return GloabState.idLoginUser;
        }catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }
}
