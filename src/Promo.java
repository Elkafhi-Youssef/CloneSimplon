public class Promo {
    protected String namePromo;
    protected int idPromo;

    protected int idFormateur;

    public Promo(String namePromo, int idPromo,int idFormateur){
        this.idPromo = idPromo;
        this.namePromo = namePromo;
        this.idFormateur = idFormateur;
    }
}
