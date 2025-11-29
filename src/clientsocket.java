import java.net.*;
import java.io.*;
import java.util.Scanner;

public class clientsocket {
    public static void main(String[] args){
        try {
            Socket sk = new Socket("127.0.0.1", 5000);
            System.out.println("Da ket noi voi SEVER");
            PrintWriter out = new PrintWriter(sk.getOutputStream(),true);
            BufferedReader bf = new BufferedReader(new InputStreamReader(sk.getInputStream()));

            new Thread(()->{
                try {
                    String s;
                    while((s = bf.readLine())!=null){
                        System.out.println(s);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            String s;
            Scanner sc = new Scanner(System.in);
            while (true) {
                s = sc.nextLine();
                out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}