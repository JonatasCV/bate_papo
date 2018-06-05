package tcp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tcp.servidor.TcpServer;


public class server {

    public static void main(String[] args){
        try {
            TcpServer server = new TcpServer();
            server.run();
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
