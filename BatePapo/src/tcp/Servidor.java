package tcp;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import tcp.servidor.TcpServer;

public class Servidor {

    public static void main(String[] args){
        try {
            TcpServer s = new TcpServer();
            s.start();
            
            Timer t = new Timer();            
            t.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (!s.isAlive())
                        s.start();
                }
            }, 2*60*1000, 2*60*1000);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
