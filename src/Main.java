import models.SendEnhancedRequestBody;
import models.SendEnhancedResponseBody;
import models.SendRequestMessage;
import services.Courier;
import services.SendService;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.sql.Connection;
public class Main {

    public static void main(String[] args) {
//        String jbdcURL = "jdbc:postgresql://localhost:5432/codingSchool";
//        String username = "postgres";
//        String password = "youssef1999";
//        try {
//            Connection connection = DriverManager.getConnection(jbdcURL,username,password);
//            System.out.println("Connect to postgresql");
//
//        } catch (SQLException e) {
//            System.out.println("Error in Connection With a database");
//            throw new RuntimeException(e);
//        }

//        Admin A = new Admin(1,"Admin","youssef","elkafhiyoussef@gmail.com","1234567");
//        System.out.println("menu********");
//        System.out.println("1.add newn formateur ");
//        Scanner choice = new Scanner(System.in);
//        System.out.println("enter your your choice");
//        int number;
//        number =Integer.parseInt(choice.nextLine());
//        while (number!=0){
//            number =Integer.parseInt(choice.nextLine());
//            if(number == 1){
//                A.creerFormateur();
//                for (int i = 0; i < GloabState.formateurs.size();i++)
//                {
//                    System.out.println(GloabState.formateurs.get(i).fullNmae);
//                }
//            }
//        }
//        System.out.println("xkon nta ila kant admin dir 1 ila kant prof dir 2");

//        int auth = 1;
//        int number =100;
//        int numberGlobal;
//        do {
//
//            if (auth == 1) {
//
//                Menu.menuAdmin();
//                number = Integer.parseInt(choice.nextLine());
//
//
//                switch (number) {
//                    case 1 -> Action.createFormateur();
//                    case 2 -> Action.creerApprenant();
//                    default -> System.out.println("Default ");
//                }
//            }
//        } while (number != 0) ;
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
