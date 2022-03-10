
import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main
{
    public static void main(String ...ags) throws IOException{
        
        System.out.println("waiting for connections");

        ServerSocket ss= new ServerSocket(1234);
        final Socket soc=ss.accept();
        System.out.println("connection received");

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Scanner psOut=new Scanner(soc.getInputStream());
                    while(psOut.hasNextLine()){
                        System.out.println(psOut.nextLine());
                    }
                } catch (IOException e) {}
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    BufferedWriter psIn= new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
                    Scanner sc=new Scanner(System.in);

                    while(sc.hasNextLine()){
                        psIn.write(sc.nextLine()+"\n");
                        psIn.flush();
                    }
                } catch (IOException e) {}
            }
        }).start();


    }
}
