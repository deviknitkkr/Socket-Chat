import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String... ags) throws IOException {

        System.out.println("Connection to server");
        final Socket soc = new Socket("localhost", 1234);
        System.out.println("Connected");
        new Worker().startWork(soc);
    }
}
