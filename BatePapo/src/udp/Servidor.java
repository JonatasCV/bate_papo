package udp;

import dataBase.beans.Topico;
import dataBase.dao.TopicoDAO;
import dataBase.dao.UsuarioDAO;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.List;

public class Servidor {

    private static final String HOST  = "localhost";
    private static final int PORTA    = 112233;
    private static final int MSG_SIZE = 100;

    public static void main(String[] args) throws SocketException, IOException {
        byte msg[] = new byte[MSG_SIZE];

        DatagramSocket soc = new DatagramSocket(PORTA);
        DatagramPacket pct = new DatagramPacket(msg, msg.length);
        InetAddress addr   = InetAddress.getByName(HOST);

        while (true) {
            soc.receive(pct);

            String str = new String(pct.getData());
            
            if (str.equals("!shutdown")) {
                str = "!server_shutdown";
                msg = str.getBytes();                
                pct.setData(msg);
                pct.setLength(msg.length);
                pct.setAddress(addr);
                pct.setPort(PORTA);
//                pct = new DatagramPacket(msg, msg.length, addr, PORT_ENV);

                soc = new DatagramSocket();
                soc.send(pct);
                
                break;
            }

            if (UsuarioDAO.userExists(str)) { // pesquisa o usuario no banco de dados
                while (msg != "end".getBytes() /* or timer triggered */) { // timer pq e UDP e pode nunca receber o END
                    // recebe os topicos
                }
            } else {
                str = "Usuário inexistente!";
                msg = str.getBytes();                
                pct.setData(msg);
                pct.setLength(msg.length);
                pct.setAddress(addr);
                pct.setPort(PORTA);
//                pct = new DatagramPacket(msg, msg.length, addr, PORT_ENV);

                soc = new DatagramSocket();
                soc.send(pct);
            }
        }

        soc.close();
    }
    
}