import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Worker {

    public void startWork(Socket soc){

        //Listener Thread
        new Thread(() -> {
            try {
                Scanner psOut=new Scanner(soc.getInputStream());
                while(psOut.hasNextLine()){
                    System.out.println(psOut.nextLine());
                }
            } catch (IOException ignored) {}
        }).start();

        //Writer Thread
        new Thread(() -> {
            try {
                BufferedWriter psIn= new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
                Scanner sc=new Scanner(System.in);

                while(sc.hasNextLine()){
                    psIn.write(sc.nextLine()+"\n");
                    psIn.flush();
                }
            } catch (IOException ignored) {}
        }).start();
    }
}
