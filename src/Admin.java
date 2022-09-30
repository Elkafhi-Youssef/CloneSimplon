import java.util.Scanner;
import java.util.Random;
public class Admin extends Personne{
    Random random = new Random();
  static  int id_admin = 1;



    public Admin(int id_admin,String Role,String fullName,String email, String password){
        super(Role,fullName,email,password);
        id_admin++;

    }

    public static void creerFormateur(){
        Scanner choice = new Scanner(System.in);
        System.out.println("enter Role of user");
            String Role = choice.nextLine();
            System.out.println("enter name");
            String fullNmae =choice.nextLine();
//            int id_user = random.nextInt(30);

            System.out.println("enter email");
            String email =choice.nextLine();
            System.out.println("enter password");
            String password =choice.nextLine();
        Formateur newFormateur = new Formateur(Formateur.idGloabFormateur,Role,fullNmae,email,password);
        GloabState.formateurs.add(newFormateur);


    }
    public static void creerApprenant(){
        Scanner choice = new Scanner(System.in);
        System.out.println("enter Role of user");
        String Role = choice.nextLine();
        System.out.println("enter name");
        String fullNmae =choice.nextLine();
        System.out.println("enter email");
        String email =choice.nextLine();
        System.out.println("enter password");
        String password =choice.nextLine();
        Apprenant newApprenant = new Apprenant(Apprenant.idGlobalApp,Role,fullNmae,email,password,0);
        GloabState.Apprenants.add((Apprenant) newApprenant);


    }
}
