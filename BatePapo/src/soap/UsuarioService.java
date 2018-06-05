/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soap;

import java.util.List;
import java.util.Locale;
import ws.BuscarUsuarioPorNomeRequest;
import ws.BuscarUsuarioPorNomeResponse;
import ws.InserirAcessoRequest;
import ws.InserirAcessoResponse;
import ws.InserirPesquisaRequest;
import ws.LoginTopicosInteresseRequest;
import ws.LoginTopicosInteresseResponse;
import ws.PesquisaInteressadosTopicoRequest;
import ws.PesquisaInteressadosTopicoResponse;
import ws.Usuario;
import ws.UsuariosPort;
import ws.UsuariosPortService;

public class UsuarioService {
    
    UsuariosPortService usuarioPortService;
    UsuariosPort port;

    public UsuarioService() {
        usuarioPortService = new UsuariosPortService();
        port = usuarioPortService.getUsuariosPortSoap11();
    }
    
    public Usuario buscaUsuarioPorNome(String nome){
        System.out.println("buscaUsuarioPorNome: " + nome);
        BuscarUsuarioPorNomeRequest request = new BuscarUsuarioPorNomeRequest();
        request.setNome(nome);
        BuscarUsuarioPorNomeResponse response = port.buscarUsuarioPorNome(request);
        return response.getUsuario();
    }
    
    public boolean loginTopicosInteressados(long codUsuario, List<Long> topicosInterese){
        LoginTopicosInteresseRequest requestLogin = new LoginTopicosInteresseRequest();
        requestLogin.setCodUsuario(codUsuario);
        requestLogin.getTopicos().addAll(topicosInterese);
        return port.loginTopicosInteresse(requestLogin).isStatus();
    }
    
    public void inserirAcesso(long codUsuario){
        InserirAcessoRequest requestAcesso = new InserirAcessoRequest();
        requestAcesso.setCodUsuario(codUsuario);
        port.inserirAcesso(requestAcesso);
    }
    
    public List<Usuario> pesquisaInteressadosTopico(long pesquisaTopicoId){
        PesquisaInteressadosTopicoRequest pesquisaRequest = new PesquisaInteressadosTopicoRequest();
        pesquisaRequest.setIdTopico(pesquisaTopicoId);
        return port.pesquisaInteressadosTopico(pesquisaRequest).getUsuarios();
    }
    
    public void inserirPesquisa(long pesquisaTopicoId){
        InserirPesquisaRequest inserirPesquisaRequest = new InserirPesquisaRequest();
        inserirPesquisaRequest.setTopico(pesquisaTopicoId);
        port.inserirPesquisa(inserirPesquisaRequest);
    }
}
