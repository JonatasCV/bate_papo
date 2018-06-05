package tcp;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receiver extends Thread {
    
    private final ServerSocket ss;
    private Socket soc;
    private ObjectInputStream objIn;

    public Receiver(int porta) throws IOException {
        this.ss = new ServerSocket(porta);
    }
    
    @Override
    public void run() {
        try {
            String msg;
            
            while (true) {
                try {
                    this.soc   = this.ss.accept();
                    this.objIn = new ObjectInputStream(this.soc.getInputStream()); 
                            
                    msg = (String) this.objIn.readObject();

                    Chat.recebeMsg(msg);

                    if (msg.equalsIgnoreCase("sair"))
                        break;
                    
                    this.objIn.close();
                    Thread.sleep((long) 1000);
                } catch (EOFException ex) {
                    Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }

            this.soc.close();
            this.ss.close();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
