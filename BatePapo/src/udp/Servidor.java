package udp;

import dataBase.beans.Topico;
import dataBase.dao.TopicoDAO;
import dataBase.dao.UsuarioDAO;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import ws.BuscarUsuarioPorNomeRequest;
import ws.BuscarUsuarioPorNomeResponse;
import ws.InserirAcessoRequest;
import ws.InserirAcessoResponse;
import ws.LoginTopicosInteresseRequest;
import ws.LoginTopicosInteresseResponse;
import ws.Usuario;
import ws.UsuariosPort;
import ws.UsuariosPortService;

public class Servidor {

    private static final String HOST  = "localhost";
    private static final int PORTA    = 11223;
    private static final int MSG_SIZE = 100;
    
    public static void main(String[] args) throws SocketException, IOException {
        byte msg[] = new byte[MSG_SIZE];

        DatagramSocket soc = new DatagramSocket(PORTA);
        DatagramPacket pct = new DatagramPacket(msg, msg.length);
        InetAddress addr   = InetAddress.getByName(HOST);
        UsuariosPortService usuarioPortService = new UsuariosPortService();
        UsuariosPort port;
        
        port = usuarioPortService.getUsuariosPortSoap11();

        while (true) {
            msg = new byte[MSG_SIZE];
            pct = new DatagramPacket(msg, msg.length);
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
            
            BuscarUsuarioPorNomeRequest request = new BuscarUsuarioPorNomeRequest();
            request.setNome(str.trim());
            System.out.println("Ola: " + str);
            BuscarUsuarioPorNomeResponse response = port.buscarUsuarioPorNome(request);
            Usuario usuario = response.getUsuario();
            System.out.println("Ola: " + response.getUsuario().getNome() + " id: " + response.getUsuario().getCodUsuario());
            
            List<Long> topicosInterese = new ArrayList<>();
            
            if (usuario.getNome() != null) { // pesquisa o usuario no banco de dados
                byte topicos[] = new byte[MSG_SIZE];
                String message = "";
                DatagramPacket pctTopicos = new DatagramPacket(topicos, topicos.length);
                while (!message.equalsIgnoreCase("end")){ // timer pq e UDP e pode nunca receber o END
                    topicos = new byte[MSG_SIZE];
                    soc.receive(pctTopicos);
                    message = new String(pctTopicos.getData()).trim();
                    if(!message.equalsIgnoreCase("end")){
                        topicosInterese.add(Long.parseLong(message));
                    }
                    System.out.println("Ola: " + new String(pctTopicos.getData()).trim());
                }
                LoginTopicosInteresseRequest requestLogin = new LoginTopicosInteresseRequest();
                requestLogin.setCodUsuario(usuario.getCodUsuario());
                requestLogin.getTopicos().addAll(topicosInterese);
                LoginTopicosInteresseResponse responseLogin = port.loginTopicosInteresse(requestLogin);
                
                InserirAcessoRequest requestAcesso = new InserirAcessoRequest();
                requestAcesso.setCodUsuario(usuario.getCodUsuario());
                InserirAcessoResponse responseAcesso = port.inserirAcesso(requestAcesso);
                
            } else {
                str = "Usuário inexistente!";
                msg = str.getBytes();                
                pct.setData(msg);
                pct.setLength(msg.length);
                pct.setAddress(addr);
                pct.setPort(PORTA);
//                pct = new DatagramPacket(msg, msg.length, addr, PORT_ENV);
                System.out.println("Usuario nao existe");

                soc = new DatagramSocket();
                soc.send(pct);
            }
        }

        soc.close();
    }
    
}