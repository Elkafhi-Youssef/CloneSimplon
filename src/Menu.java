import outils.ConsoleColors;
public class Menu {
    public Menu(){

    }

    public static void  menuAdmin(){
        System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT+"=======Admin Menu=====");
        System.out.println("1.Create a new formateur");
        System.out.println("2.Create a new contrller.Apprenant");
        System.out.println("3.Create a new Promo");
        System.out.println("4.Add formateur to promo");
        System.out.println("To exite enter any 0");
        System.out.println(ConsoleColors.BLACK_BACKGROUND_BRIGHT+"Please inter your choice:  ");
    }
    public static void  menuFormateur(){
        System.out.println(ConsoleColors.BLACK+"=======Formateur Menu=====");
        System.out.println("1.Add Apprenant to Promo");
        System.out.println("2.Create Brief");
        System.out.println("3.distributed Brief to promo(apprenants)");
        System.out.println("To exite enter any 0");

    }
    public static void registerChoice(){
        System.out.println("1.Register as Admin");
        System.out.println("2.Register as contrller.Formateur");
        System.out.println(ConsoleColors.BLUE+ "Plaese enter your Choice");
    }
}
