import global.GloabState;
import module.Briefs;
import outils.ConsoleColors;

import java.util.Scanner;

public class Brief {
    protected int briefId;
    protected String titleBrief;
    protected String descreption;
    protected int idFormatuer;

    public Brief(){

    }
    public Brief(int briefId, String titleBrief, String descreption, int idformatuer){
        this.briefId = briefId;
        this.titleBrief = titleBrief;
        this.descreption = descreption;
        this.idFormatuer = idformatuer;
    }
    public void createBrief(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.BLUE+"Please enter the brief title");
        this.titleBrief = scanner.nextLine();
        System.out.println(ConsoleColors.BLUE+"Please enter the brief description");
        this.descreption = scanner.nextLine();
        if(Briefs.addBrief(this.titleBrief,this.descreption, GloabState.idLoginUser)){
            System.out.println(ConsoleColors.GREEN+"The operation done successful");
        }else{
            System.out.println(ConsoleColors.RED+"the operation failed");
        }
    }
}
