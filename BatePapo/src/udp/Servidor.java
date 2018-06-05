package udp;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import udp.servidor.UdpServer;


public class Servidor {
    
    public static void main(String[] args) {
        try {
            UdpServer updServer = new UdpServer();
            updServer.start();
        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
