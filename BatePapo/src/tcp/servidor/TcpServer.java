package tcp.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import soap.UsuarioService;
import ws.Usuario;

public class TcpServer extends Thread{
    
    private static final String HOST = "localhost";
    private static final int PORTA   = 2020;
    private final ServerSocket ss;
    private boolean running;
    private final UsuarioService service;

    public TcpServer() throws IOException {
        // Criando server socket
       ss = new ServerSocket(PORTA);
       service = new UsuarioService();
    }
    
    @Override
    public void run() {
        
        running = true;
        System.out.println("Servidor TCP running on port: " + PORTA);
        try {
            while(running){

                //Cria um socket quando recebe coneção
                Socket socket = ss.accept();
                //Cria um fluxo de input
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                
                int pesquisaTopicoId = input.readInt();
                System.out.println("Recebido Topico: " + pesquisaTopicoId);

                //Busca usuarios interessados no topico e registra a pesquisa
                List<Usuario> usuarios = service.pesquisaInteressadosTopico(pesquisaTopicoId);
                System.out.println("Size: " + usuarios.size());
                service.inserirPesquisa(pesquisaTopicoId);
                
                //Printa usuarios apenas para conferencia
                usuarios.forEach((user) -> {
                    System.out.println("Usuario: " + user.getNome() + " endereço ip: " + user.getIPaddress());
                });
                
                //Envia resposta
                ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(usuarios);
                output.flush();

                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(TcpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
 }
