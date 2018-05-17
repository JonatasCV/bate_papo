package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class client {

    private static final String HOST = "localhost";
    private static final int PORTA   = 998877;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Cliente");
        ServerSocket ss = new ServerSocket(PORTA);
        Socket soc      = new Socket(HOST, PORTA);
        String msg      = new String("Oi");

        ObjectInputStream  objIn  = new ObjectInputStream(soc.getInputStream());
        ObjectOutputStream objOut = new ObjectOutputStream(soc.getOutputStream());

        objOut.writeObject(msg);
        objOut.flush();
        System.out.println("Mensagem enviada.");
        objOut.close();
        
        soc = ss.accept();

        msg = (String) objIn.readObject();
        System.out.println("Recebido: " + msg);
        soc.close();
        ss.close();
    }
    
}
