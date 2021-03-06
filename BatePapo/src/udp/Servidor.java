package udp;

import java.net.SocketException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import udp.servidor.UdpServer;

public class Servidor {
    
    public static void main(String[] args) {        
        try {
            UdpServer s = new UdpServer();
            s.start();
            
            Timer t = new Timer();            
            t.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (!s.isAlive())
                        s.start();
                }
            }, 2*60*1000, 2*60*1000);
        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
