package module;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import global.GloabState;

public class Promos {
    static Connection con = ConnectDb.con;

    public static int getPromoId(int idFormateur, int IdBrief){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select promos.id_promo from briefs JOIN promos on briefs.id_formateur = promos.id_formateur WHERE briefs.id_formateur= ? and briefs.id_brief= ?");
            preparedStatement.setInt(1, idFormateur);
            preparedStatement.setInt(2, IdBrief );
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_promo");
                GloabState.idPromo = id;
            }
            return GloabState.idPromo;
        }catch (SQLException e) {
            System.out.println("Error in Login Function");
            throw new RuntimeException(e);
        }
    }
}
