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

public class server {

    private static final String HOST  = "localhost";
    private static final int PORTA    = 112233;
    private static final int MSG_SIZE = 100;

    public static void main(String[] args) throws SocketException, IOException {
        byte msg[] = new byte[MSG_SIZE];

        DatagramSocket soc = new DatagramSocket(PORTA);
        DatagramPacket pct = new DatagramPacket(msg, msg.length);
        InetAddress addr   = InetAddress.getByName(HOST);

        boolean logged = false; // status usuario logado

        while (true) {
            soc.receive(pct);
//            soc.close();

            String str = new String(pct.getData());

            if (str.toLowerCase().equals("sair")) { // manda msg para cliente e encerra
                str = "sair";
                msg = str.getBytes();                
                pct.setData(msg);
                pct.setLength(msg.length);
                pct.setAddress(addr);
                pct.setPort(PORTA);

                soc = new DatagramSocket();
                soc.send(pct);
                
                break;
            }
            
            if (logged) {  // se ja estiver logado
                if (TopicoDAO.TopicExists(str)) { // verifica se o topico informado pelo cliente existe
                    // se existe: cadastra o cliente no topico
                } else {
                    // se nao existe: informa (e pede para informar novamente um topico?)
                    str = "Tópico não encontrado!";
                }
                
                // se entrou no topico devera mostrar as pessoas que estao disponiveis para conversa no topico
            }
            else if (UsuarioDAO.userExists(str)) { // se ainda tiver que logar
                logged = true;
                
                // envia mensagem que indica que varias seram enviadas em sequencia para o cliente
                str = "begin";
                msg = str.getBytes();                
                pct.setData(msg);
                pct.setLength(msg.length);
                pct.setAddress(addr);
                pct.setPort(PORTA);
                soc = new DatagramSocket();
                soc.send(pct);
                
                str = "Topicos disponíveis:";
                msg = str.getBytes();                
                pct.setData(msg);
                pct.setLength(msg.length);
                pct.setAddress(addr);
                pct.setPort(PORTA);

                soc = new DatagramSocket();
                soc.send(pct);

                // envia cada topico em um mensagem para o cliente
                // (esta assim pq na descricao diz para enviar CADA topico em uma msg)
                List<Topico> topicos = TopicoDAO.findAll();
                for (Topico t : topicos) {
                    str = t.getNome();
                    msg = str.getBytes();                
                    pct.setData(msg);
                    pct.setLength(msg.length);
                    pct.setAddress(addr);
                    pct.setPort(PORTA);

                    soc = new DatagramSocket();
                    soc.send(pct);
                }
                
                // envia confirmacao de que todos os topicos foram enviados
                str = "end";
                msg = str.getBytes();                
                pct.setData(msg);
                pct.setLength(msg.length);
                pct.setAddress(addr);
                pct.setPort(PORTA);
                soc = new DatagramSocket();
                soc.send(pct);
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