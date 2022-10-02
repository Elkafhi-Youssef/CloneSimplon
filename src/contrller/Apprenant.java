package contrller;

public class Apprenant extends Personne {
    public String idPerson;
    public int  idPromo ;
    public Apprenant(int idpersone,String fullNmae,String email, int idPromo ){
        super(idpersone,fullNmae,email);
        this.idPromo = idPromo;
    }
}
