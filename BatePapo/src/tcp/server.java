package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    private static final String HOST = "localhost";
    private static final int PORTA   = 998877;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Servidor");
        ServerSocket ss = new ServerSocket(PORTA);
        Socket soc      = ss.accept();
        
        ObjectInputStream  objIn  = new ObjectInputStream(soc.getInputStream());
        ObjectOutputStream objOut = new ObjectOutputStream(soc.getOutputStream());
        
        String msg = (String) objIn.readObject();
        System.out.println("Recebido: " + msg);

        msg = new String("Tiau");

        soc = new Socket(HOST, PORTA);

        objOut.writeObject(msg);
        objOut.flush();
        System.out.println("Mensagem enviada.");
        objOut.close();

        soc.close();
        ss.close();
    }
    
}
