package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {

    private static final String HOST  = "localhost";
    private static final int PORTA    = 112233;
    private static final int MSG_SIZE = 100;

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        byte msg[] = new byte[MSG_SIZE];
        InetAddress addr = InetAddress.getByName(HOST);

        DatagramSocket soc = new DatagramSocket();
        DatagramPacket pct = new DatagramPacket(msg, msg.length, addr, PORTA);
        
        Scanner ioIn = new Scanner(System.in);
        
        while (true) {
            System.out.println("Usuário:");
            String str = ioIn.nextLine();
            msg = str.getBytes();
            soc.send(pct); // envia nome de usuario para validacao no server

            soc = new DatagramSocket(PORTA);
            msg = new byte[MSG_SIZE];
            pct = new DatagramPacket(msg, msg.length);

            soc.receive(pct);
            str = new String(pct.getData());
            
            if (str.equals("sair")) 
                break;

            // isso para listar os topicos (esta assim pq na descricao diz para enviar CADA topico em uma msg)
            if (str.equals("begin")) { // se forem varias mensagens...
                while (!str.equals("end")) { // ...fica recebendo ate que chegue a mensagem "end"
                    soc.receive(pct);
                    str = new String(pct.getData());
                    System.out.println(str);
                }
            } else
                System.out.println(str);
            
            // pede pro usuario informar o topico desejado
        }
        
        soc.close();
    }
    
}
