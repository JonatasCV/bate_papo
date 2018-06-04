package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import ws.InserirPesquisaRequest;
import ws.PesquisaInteressadosTopicoRequest;
import ws.PesquisaInteressadosTopicoResponse;
import ws.Usuario;
import ws.UsuariosPort;
import ws.UsuariosPortService;

public class server {

    private static final String HOST = "localhost";
    private static final int PORTA   = 9876;
    private static UsuariosPortService usuarioPortService = new UsuariosPortService();
    private static UsuariosPort port = usuarioPortService.getUsuariosPortSoap11();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Servidor");
        
        // Criando server socket
        ServerSocket ss = new ServerSocket(2020);
        System.out.println("Servidor iniciado na porta 3322 + " + InetAddress.getLocalHost());
        
        while(true){
            //Cria um socket quando recebe coneção
            Socket socket = ss.accept();
            
            //Cria um fluxo de input
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
             
            
            int pesquisaTopicoId = input.readInt();
            System.out.println("Recebido: " + pesquisaTopicoId); 
            
            PesquisaInteressadosTopicoRequest pesquisaRequest = new PesquisaInteressadosTopicoRequest();
            pesquisaRequest.setIdTopico(pesquisaTopicoId);
            PesquisaInteressadosTopicoResponse responseTopicos = port.pesquisaInteressadosTopico(pesquisaRequest);
            
            InserirPesquisaRequest inserirPesquisaRequest = new InserirPesquisaRequest();
            inserirPesquisaRequest.setTopico(pesquisaTopicoId);
            port.inserirPesquisa(inserirPesquisaRequest);
            
            List<Usuario> usuarios = responseTopicos.getUsuarios();
            System.out.println("Size: " + usuarios.size());
            
            for(Usuario user : usuarios){
                System.out.println("Usuario: " + user.getNome() + " endereço ip: " + user.getIPaddress());
            }
            //Envia resposta
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            String resposta = "chegou";
            output.writeObject(usuarios);
            output.flush();
            
            socket.close();
        }
    }
    
}
