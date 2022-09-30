public class Apprenant extends Personne {
    protected int  idPromo = 1;
    protected int idApprenant;
    static int idGlobalApp = 0;
    public Apprenant(int idApprenant,String Role,String fullNmae,String email, String password,int  idPromo){
        super(Role,fullNmae,email,password);
        this.idApprenant = idApprenant;
        idGlobalApp++;
    }
}
