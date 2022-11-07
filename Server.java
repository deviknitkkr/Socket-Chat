
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String... ags) throws IOException {

        System.out.println("waiting for connections");
        ServerSocket ss = new ServerSocket(1234);
        final Socket soc = ss.accept();
        System.out.println("connection received");
        new Worker().startWork(soc);
    }
}
