package module;

import contrller.Apprenant;
import outils.ConsoleColors;
import global.GloabState;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Users {
    static Connection con = ConnectDb.con;

    public static boolean addFormateur(String fullname, String email, String password){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO formateurs ( fullname, email, password) VALUES (?, ?, ?)");
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
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
    public static boolean addApprenant(String fullname, String email){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO apprenants ( fullname, email) VALUES (?, ?)");
            preparedStatement.setString(1, fullname);
            preparedStatement.setString(2, email);
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
    public static boolean addPromo(String promoName){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO promos(name_promo) VALUES (?)");
            preparedStatement.setString(1, promoName);
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
    public static void getAllFormateur(){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from formateurs");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_formateur");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                System.out.println(ConsoleColors.YELLOW+"formateur id is"+id + ", formateur fullname" + fullname + "," + email );
            }
        }catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }
    public static void getAllApprenant(){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from apprenants");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_apprenant");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                System.out.println(ConsoleColors.YELLOW+"contrller.Apprenant id is"+id + ", contrller.Apprenant fullname" + fullname + ", Email of apprenant" + email );
            }
        }catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }
    public static void getAllPromo(){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from promos");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_promo");
                String namePromo = rs.getString("name_promo");
                System.out.println(ConsoleColors.YELLOW+"Promo id is: "+id + ", promo name is " + namePromo );
            }
        }catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }
    public static boolean addFormateurToPromo(int idFormateur,int idPromo){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE promos SET id_formateur = ? WHERE id_promo= ?");
            preparedStatement.setInt(1, idFormateur);
            preparedStatement.setInt(2, idPromo);
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
    public static boolean addApprenantToPromo(int idApprenant,int idPromo){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE apprenants SET id_promo = ? WHERE id_apprenant= ?");
            preparedStatement.setInt(1, idPromo);
            preparedStatement.setInt(2, idApprenant);
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
    public static void getAllApprenantByIdPromo(int idPromo){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select  * from apprenants JOIN promos on apprenants.id_promo = promos.id_promo WHERE promos.id_promo = ?");
            preparedStatement.setInt(1, idPromo);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idApprenant = rs.getInt("id_apprenant");
                int idpromo = rs.getInt("id_promo");
                String fullname = rs.getString("fullname");
                String namePromo = rs.getString("name_promo");
                String email = rs.getString("email");
                GloabState.Apprenants.add(new Apprenant(idApprenant,fullname,email,idpromo));
//                System.out.println(ConsoleColors.YELLOW+"contrller.Apprenant id is "+idApprenant + ", contrller.Apprenant fullname " + fullname + ", Email of apprenant" + email + ", promo name of apprenant is "+ namePromo);

            }
        }catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }
}

