import contrller.Apprenant;
import contrller.Sendemail;
import global.GloabState;
import module.Briefs;
import module.Promos;
import module.Users;
import outils.ConsoleColors;

import java.util.Scanner;

public class Action {



    public Action(){


    }
    public void createFormateur(){
//
    }

    public static Boolean loginAdmin(String email,String password){
        return Auth.login(email,password);
    }
    public static int loginFormateur(String email,String password){
        return Auth.loginFormateur(email,password);
    }
    public static void createFormatuer(){
        Admin a = new Admin();
        a.creerFormateur();
    }
    public static void createApprenant(){
        Admin a = new Admin();
        a.creerApprenant();
    }
    public static void createBrief(){
        Brief b = new Brief();
        b.createBrief();
    }
    public static void createPromo(){
        Admin a = new Admin();
        a.creerPromo();
    }
    public static void addFormateurToPromo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.RED+"==>List of formateurs");
        Users.getAllFormateur();
        System.out.println(ConsoleColors.RED+"==>list of promos");
        Users.getAllPromo();
        System.out.println(ConsoleColors.BLUE+"Chose id of formateur");
        int idFormateur = scanner.nextInt();
        System.out.println(ConsoleColors.BLUE+"Chose id of promo");
        int idPromo = scanner.nextInt();
        if(Users.addFormateurToPromo(idFormateur,idPromo)){
            System.out.println(ConsoleColors.GREEN+"The operation done successful");
        }else{
            System.out.println(ConsoleColors.RED+"the operation failed");
        }
    }
    public static void addApprenantToPromo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.RED+"==>List of Appenants");
        Users.getAllApprenant();
        System.out.println(ConsoleColors.RED+"==>list of promos");
        Users.getAllPromo();
        System.out.println(ConsoleColors.BLUE+"Chose id of contrller.Apprenant");
        int idApprenant = scanner.nextInt();
        System.out.println(ConsoleColors.BLUE+"Chose id of promo");
        int idPromo = scanner.nextInt();
        if(Users.addApprenantToPromo(idApprenant,idPromo)){
            System.out.println(ConsoleColors.GREEN+"The operation done successful");
        }else{
            System.out.println(ConsoleColors.RED+"the operation failed");
        }
    }
    public static void distributedBriefs(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.RED+"==>List of briefs");
        Briefs.getAllBriefs();
        System.out.println(ConsoleColors.BLUE+"Please Enter the brief id");
        int idBrief = scanner.nextInt();
        GloabState.idBrief = idBrief;
        int idPromo = Promos.getPromoId(GloabState.idLoginUser,idBrief);
        System.out.println(idPromo);
        Users.getAllApprenantByIdPromo(idPromo);
        for (Apprenant apprenant: GloabState.Apprenants) {
            System.out.println(ConsoleColors.YELLOW+ " Apprenant fullname " + apprenant.fullNmae + ", Email of apprenant " + apprenant.email + ", promo id of apprenant is "+ apprenant.idPromo);
            Sendemail.sendEmail(apprenant.email,apprenant.fullNmae);
        }
        if (Briefs.addBriefToPromo(idBrief,idPromo)) {
            System.out.println(ConsoleColors.GREEN+ " the operation done successful");
        } else{
            System.out.println(ConsoleColors.RED+"the operation failed");
        }
    }
}
