import contrller.Personne;
import module.Users;

import java.util.Scanner;
import java.util.Random;
public class Admin extends Personne {
    Random random = new Random();
  static  int id_admin = 1;


    public Admin(){
        super();
    }
//    public Admin(int id_admin,String fullName,String email, String password){
//        super(fullName,email,password);
//        id_admin++;
//
//    }

    public  void creerFormateur(){
        Scanner choice = new Scanner(System.in);
        System.out.println("enter name");
        String fullName =choice.nextLine();
        System.out.println("enter email");
        String email =choice.nextLine();
        System.out.println("enter password");
        String password =choice.nextLine();
        if(Users.addFormateur(fullName,email,password)){
            System.out.println("the formateur create successful");
        }
    }
    public  void creerApprenant(){
        Scanner choice = new Scanner(System.in);
        System.out.println("enter name");
        String fullName =choice.nextLine();
        System.out.println("enter email");
        String email =choice.nextLine();
        System.out.println("enter password");
        String password =choice.nextLine();
        if(Users.addApprenant(fullName,email)){
            System.out.println("the apprenant create successful");
        }


    }
    public  void creerPromo(){
        Scanner choice = new Scanner(System.in);
        System.out.println("Enter the promo name");
        String promoName =choice.nextLine();
        if(Users.addPromo(promoName)){
            System.out.println("the new promo create successful");
        }


    }
}
