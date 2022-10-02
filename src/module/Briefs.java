package module;
import outils.ConsoleColors;
import global.GloabState;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Briefs {
    static Connection con = ConnectDb.con;
    public static boolean addBrief(String title, String description,int idFormateur){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO briefs ( title, description,id_formateur) VALUES (?, ?,?)");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, idFormateur);
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }else{
                return false;
            }
        }catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }
    public static void getAllBriefs(){
        try {
            int idFormateur = GloabState.idLoginUser;
            PreparedStatement preparedStatement = con.prepareStatement("select * from briefs where id_formateur = ? ");
            preparedStatement.setInt(1, idFormateur);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_brief");
                String title = rs.getString("title");
                String description = rs.getString("description");
                System.out.println(ConsoleColors.YELLOW+"Brief id is "+id+ ", Brief title is " + title + ",description of brief: " + description );
            }
        }catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }
    public static boolean addBriefToPromo(int idBrief, int idPromo){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO briefofpromo( id_brief, id_promo) VALUES (?, ?)");
            preparedStatement.setInt(1, idBrief);
            preparedStatement.setInt(2,idPromo );
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }else{
                return false;
            }
        }catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }
}
