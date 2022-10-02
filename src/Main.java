import models.SendEnhancedRequestBody;
import models.SendEnhancedResponseBody;
import models.SendRequestMessage;
import module.ConnectDb;
import outils.ConsoleColors;
import services.Courier;
import services.SendService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        ConnectDb conn = ConnectDb.connect();
        Scanner scanner = new Scanner(System.in);
        System.out.println(ConsoleColors.GREEN+"------Welcome----------");
        System.out.println(ConsoleColors.BLACK_BACKGROUND_BRIGHT);
        Menu.registerChoice();
        int regiseras = scanner.nextInt();
        scanner.nextLine();
        if (regiseras == 1) {
            System.out.println("Please enter your email");
            String email = scanner.nextLine();
            System.out.println("==>Please enter your password;");
            String password = scanner.nextLine();
            boolean login =Action.loginAdmin("elkafhiyoussef@gmail.com","admin");
//            // here I have to create a function name is login successful
            if(login){
                int choiceInMenuAdmin = 1;
                while (choiceInMenuAdmin!=0){
                    Menu.menuAdmin();
                    choiceInMenuAdmin = scanner.nextInt();

                    switch (choiceInMenuAdmin) {
                        case 1 -> Action.createFormatuer();
                        case 2 -> Action.createApprenant();
                        case 3 -> Action.createPromo();
                        case 4 -> Action.addFormateurToPromo();
                        default -> System.out.println("bye");
                    }
                }


            }else{
                System.out.println("failed");
            }

            System.out.println("here daz");
        } else if (regiseras == 2) {
            System.out.println("Please enter your email");
            String email = scanner.nextLine();
            System.out.println("==>Please enter your password;");
            String password = scanner.nextLine();
            int loginformateur = Action.loginFormateur("josephekfi@gmail.com","formateur");
            if(loginformateur != 0){
                int choiceInMenuFormateur = 1;
                while (choiceInMenuFormateur!=0){
                    Menu.menuFormateur();
                    choiceInMenuFormateur = scanner.nextInt();

                    switch (choiceInMenuFormateur) {
                        case 1 -> Action.addApprenantToPromo();
                        case 2 -> Action.createBrief();
                        case 3 -> Action.distributedBriefs();
                        default -> System.out.println("bye");
                    }
                }


            }else{
                System.out.println("failed");
            }
        }
        System.out.println(ConsoleColors.WHITE );
    }

    public void  sendEmail(){
        Courier.init("pk_prod_JVRDNC96WMM33NHR8WEG9G5P8ABY");

        SendEnhancedRequestBody sendEnhancedRequestBody = new SendEnhancedRequestBody();
        SendRequestMessage sendRequestMessage = new SendRequestMessage();
        HashMap<String, String> to = new HashMap<String, String>();
        to.put("email", "elkafhiyoussef@gmail.com");
        sendRequestMessage.setTo(to);

        HashMap<String, String> content = new HashMap<String, String>();
        content.put("title", "Welcome to Courier");
        content.put("body", "Want to hear a joke? {{joke}}");
        sendRequestMessage.setContent(content);

        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("joke", "Why do Java programmers have to wear glasses? Because they don't C#");
        sendRequestMessage.setData(data);
        sendEnhancedRequestBody.setMessage(sendRequestMessage);

        try {
            SendEnhancedResponseBody response = new SendService().sendEnhancedMessage(sendEnhancedRequestBody);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
