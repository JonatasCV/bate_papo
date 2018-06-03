package tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import ws.PesquisaInteressadosTopicoRequest;
import ws.PesquisaInteressadosTopicoResponse;
import ws.Usuario;
import ws.UsuariosPort;
import ws.UsuariosPortService;

public class server {

    private static final String HOST = "localhost";
    private static final int PORTA   = 9876;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Servidor");
        
        UsuariosPortService usuarioPortService = new UsuariosPortService();
        UsuariosPort port;
        port = usuarioPortService.getUsuariosPortSoap11();
        
        int pesquisaTopicoId;
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            
            //ObjectOutputStream os = new ObjectOutputStream(connectionSocket.getOutputStream());
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            pesquisaTopicoId = Integer.parseInt(inFromClient.readLine());
            PesquisaInteressadosTopicoRequest pesquisaRequest = new PesquisaInteressadosTopicoRequest();
            pesquisaRequest.setIdTopico(pesquisaTopicoId);
            PesquisaInteressadosTopicoResponse responseTopicos = port.pesquisaInteressadosTopico(pesquisaRequest);
            List<Usuario> usuarios = responseTopicos.getUsuarios();
            System.out.println("Received: " + pesquisaTopicoId);
            System.out.println("Size: " + usuarios.size());
            
            for(Usuario user : usuarios){
                System.out.println("User Ip: " + user.getIPaddress());
            }
            
            ObjectOutputStream outputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
            System.out.println("Object to be written = " + usuarios.size());
            outputStream.writeObject(usuarios.get(0));
            
            
        }
    }
    
}
