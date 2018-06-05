package tcp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender {

    private final String host;
    private final int porta;

    public Sender(String host, int porta) {
        this.host  = host;
        this.porta = porta;
    }
    
    public void send(String mensagem) throws IOException {
        Socket soc = new Socket(this.host, this.porta);

        ObjectOutputStream objOut = new ObjectOutputStream(soc.getOutputStream());

        objOut.writeObject(mensagem);
        objOut.flush();

        objOut.close();
        soc.close();
    }
}
