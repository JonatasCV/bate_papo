/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp.servidor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import soap.UsuarioService;
import ws.Usuario;

public class UdpServer extends Thread {
	 
    private final DatagramSocket socket;
    private boolean running;
    private static final String HOST  = "localhost";
    private static final int PORTA    = 11223;
    private static final int MSG_SIZE = 100;;
    private byte[] msg = new byte[MSG_SIZE];
    private final UsuarioService service;
 
    public UdpServer() throws SocketException {
        service = new UsuarioService();
        socket = new DatagramSocket(PORTA); 
    }
 
    public void run() {
        running = true;
        System.out.println("UDP server start running on port: " + PORTA); 

        try {
            while (running) {
                
                //Rebe Dados (Nome do usurio)
                msg = new byte[MSG_SIZE];
                DatagramPacket pct = new DatagramPacket(msg, msg.length);
                socket.receive(pct);
                
                //Busca usuario no web service soap
                String str = new String(pct.getData());
                Usuario usuario = service.buscaUsuarioPorNome(str.trim());

                List<Long> topicosInterese = new ArrayList<>();

                if (usuario.getNome() != null) { 
                    System.out.println("Ola: " + usuario.getNome() + " id: " + usuario.getCodUsuario());
                    
                    byte topicos[] = new byte[MSG_SIZE];
                    String message = "";
                    DatagramPacket pctTopicos = new DatagramPacket(topicos, topicos.length);
                    
                    while (!message.equalsIgnoreCase("end")){
                        socket.receive(pctTopicos);
                        message = new String(pctTopicos.getData()).trim();
                        if(!message.equalsIgnoreCase("end")){
                            topicosInterese.add(Long.parseLong(message));
                        }
                        System.out.println("Topico id: " + new String(pctTopicos.getData()).trim());
                    }
                    
                    service.loginTopicosInteressados(usuario.getCodUsuario(), topicosInterese);           
                    service.inserirAcesso(usuario.getCodUsuario());
                    
                    // Enviando resposta instanciando pacote 
                    byte[] buf = new byte[MSG_SIZE]; 

                    //Converte objeto de reposta para byte
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    ObjectOutputStream os = new ObjectOutputStream(outputStream);
                    os.writeObject(usuario);
                    buf = outputStream.toByteArray();

                    DatagramPacket resposta = new DatagramPacket(buf, buf.length, pctTopicos.getAddress(), pctTopicos.getPort());
                    socket.send(resposta);

                } else {
                    System.out.println("Usuario nao existe");

                    byte[] buf = new byte[MSG_SIZE]; 

                    //Converte objeto de reposta para byte
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    ObjectOutputStream os = new ObjectOutputStream(outputStream);
                    os.writeObject(new Usuario());
                    buf = outputStream.toByteArray();

                    DatagramPacket resposta = new DatagramPacket(buf, buf.length, pct.getAddress(), pct.getPort());
                    socket.send(resposta);
                }
                
            }
            socket.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        
    }
}