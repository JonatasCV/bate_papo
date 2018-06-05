package udp.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import javax.swing.JOptionPane;
import udp.Cliente;
import ws.Usuario;

public class UdpClient {
    private static final String HOST  = "localhost";
    private static final int PORTA    = 11223;
    private static final int MSG_SIZE = 100;
    private final DatagramSocket socket;
    private final InetAddress address;
 
    private byte[] receiveBuf = new byte[MSG_SIZE];
    private byte[] msg = new byte[MSG_SIZE];
    
    public UdpClient() throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName(HOST);
    }
    
    public Usuario login(String nome, List<String> selecionados) throws IOException, ClassNotFoundException {

            if (nome.length() > MSG_SIZE){
                return new Usuario();
            }
            
            //Envia nome do usuario para socket
            msg = nome.getBytes();        
            DatagramPacket pct = new DatagramPacket(msg, msg.length, address, PORTA);
            socket.send(pct);

            for(String topico : selecionados){
                msg = topico.getBytes();
                socket.send(new DatagramPacket(msg, msg.length, address, PORTA));
            }
            
            msg = "end".getBytes();
            socket.send(new DatagramPacket(msg, msg.length, address, PORTA));
            
            receiveBuf = new byte[256];
            
            //Create a response DatagramPacket and wait for server response
            DatagramPacket receivePacket = new DatagramPacket(receiveBuf, receiveBuf.length);
            socket.receive(receivePacket);
            
            //Read and convert response to UDPReponse
            ByteArrayInputStream in = new ByteArrayInputStream(receivePacket.getData());
            ObjectInputStream is = new ObjectInputStream(in);
            return (Usuario) is.readObject();
    }
 
    public void close() {
        socket.close();
    }
}
