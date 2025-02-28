import java.io.*;
import java.time.LocalDateTime;
import javax.net.ssl.*;
import java.util.*;

class MailTry {
    private static DataOutputStream dos;
    public static BufferedReader br;

    public static void main(String argv[]) throws Exception {
        String user = ""; //change
        Scanner str =new Scanner(System.in);
        String pass = "pss";  //change
        //String pass = str.newline();
        String username =new String(Base64.getEncoder().encode(user.getBytes()));
        String password = new String(Base64.getEncoder().encode(pass.getBytes()));
        SSLSocket s = (SSLSocket) SSLSocketFactory.getDefault().createSocket("smtp.gmail.com", 465);
        dos = new DataOutputStream(s.getOutputStream());
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));



        send("EHLO smtp.gmail.com\r\n");
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());
        System.out.println("SERVER: "+ br.readLine());



        send("AUTH LOGIN\r\n");
        System.out.println("SERVER: "+ br.readLine());


        send(username + "\r\n");
        System.out.println("SERVER: "+ br.readLine());



        send(password + "\r\n");
        System.out.println("SERVER: "+ br.readLine());


        send("MAIL FROM:<s2111176129@ru.ac.bd>\r\n");//change
        System.out.println("SERVER: "+ br.readLine());


        send("RCPT TO:<iqbalmahbub420@gmail.com>\r\n");//change

        System.out.println("SERVER: "+ br.readLine());



        send("DATA\r\n");
        System.out.println("SERVER: "+ br.readLine());


        send("FROM: s2111176129@ru.ac.bd\r\n");//change
        send("TO: iqbalmahbub420@gmail.com\r\n");//change2

        send("Subject: 3Y2S2023"+ "\r\n ");
        send(" \r\n");
        send("2111176129 \r\n") ;
        send( LocalDateTime.now() +"\r\n");
        send(".\r\n");
        System.out.println("SERVER: "+ br.readLine());



        send("QUIT\r\n");
        System.out.println("SERVER: "+ br.readLine());
    }

    private static void send(String s) throws Exception {
        dos.writeBytes(s);
        Thread.sleep(100);
        System.out.println("CLIENT: " + s);
    }
}