public class Formateur  extends Personne{
    static int idGloabFormateur = 1;
    protected int id_formateur;

    public Formateur(int id_formateur,String Role, String fullNmae, String email, String password){
        super(Role,fullNmae,email,password);
        this.id_formateur = id_formateur;
        idGloabFormateur++;
    }
    public void ajouteAppToPromo(int idApp,Promo P){


    }
}
