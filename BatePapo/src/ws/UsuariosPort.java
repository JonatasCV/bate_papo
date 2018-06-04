
package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UsuariosPort", targetNamespace = "http://www.batepapo.com/xml/users")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UsuariosPort {


    /**
     * 
     * @param excluirUsuarioRequest
     * @return
     *     returns ws.ExcluirUsuarioResponse
     */
    @WebMethod
    @WebResult(name = "excluirUsuarioResponse", targetNamespace = "http://www.batepapo.com/xml/users", partName = "excluirUsuarioResponse")
    public ExcluirUsuarioResponse excluirUsuario(
        @WebParam(name = "excluirUsuarioRequest", targetNamespace = "http://www.batepapo.com/xml/users", partName = "excluirUsuarioRequest")
        ExcluirUsuarioRequest excluirUsuarioRequest);

    /**
     * 
     * @param pesquisaInteressadosTopicoRequest
     * @return
     *     returns ws.PesquisaInteressadosTopicoResponse
     */
    @WebMethod
    @WebResult(name = "pesquisaInteressadosTopicoResponse", targetNamespace = "http://www.batepapo.com/xml/users", partName = "pesquisaInteressadosTopicoResponse")
    public PesquisaInteressadosTopicoResponse pesquisaInteressadosTopico(
        @WebParam(name = "pesquisaInteressadosTopicoRequest", targetNamespace = "http://www.batepapo.com/xml/users", partName = "pesquisaInteressadosTopicoRequest")
        PesquisaInteressadosTopicoRequest pesquisaInteressadosTopicoRequest);

    /**
     * 
     * @param buscarUsuarioPorNomeRequest
     * @return
     *     returns ws.BuscarUsuarioPorNomeResponse
     */
    @WebMethod
    @WebResult(name = "buscarUsuarioPorNomeResponse", targetNamespace = "http://www.batepapo.com/xml/users", partName = "buscarUsuarioPorNomeResponse")
    public BuscarUsuarioPorNomeResponse buscarUsuarioPorNome(
        @WebParam(name = "buscarUsuarioPorNomeRequest", targetNamespace = "http://www.batepapo.com/xml/users", partName = "buscarUsuarioPorNomeRequest")
        BuscarUsuarioPorNomeRequest buscarUsuarioPorNomeRequest);

    /**
     * 
     * @param incluirUsuarioRequest
     * @return
     *     returns ws.IncluirUsuarioResponse
     */
    @WebMethod
    @WebResult(name = "incluirUsuarioResponse", targetNamespace = "http://www.batepapo.com/xml/users", partName = "incluirUsuarioResponse")
    public IncluirUsuarioResponse incluirUsuario(
        @WebParam(name = "incluirUsuarioRequest", targetNamespace = "http://www.batepapo.com/xml/users", partName = "incluirUsuarioRequest")
        IncluirUsuarioRequest incluirUsuarioRequest);

    /**
     * 
     * @param loginTopicosInteresseRequest
     * @return
     *     returns ws.LoginTopicosInteresseResponse
     */
    @WebMethod
    @WebResult(name = "loginTopicosInteresseResponse", targetNamespace = "http://www.batepapo.com/xml/users", partName = "loginTopicosInteresseResponse")
    public LoginTopicosInteresseResponse loginTopicosInteresse(
        @WebParam(name = "loginTopicosInteresseRequest", targetNamespace = "http://www.batepapo.com/xml/users", partName = "loginTopicosInteresseRequest")
        LoginTopicosInteresseRequest loginTopicosInteresseRequest);

    /**
     * 
     * @param inserirPesquisaRequest
     * @return
     *     returns ws.InserirPesquisaResponse
     */
    @WebMethod
    @WebResult(name = "inserirPesquisaResponse", targetNamespace = "http://www.batepapo.com/xml/users", partName = "inserirPesquisaResponse")
    public InserirPesquisaResponse inserirPesquisa(
        @WebParam(name = "inserirPesquisaRequest", targetNamespace = "http://www.batepapo.com/xml/users", partName = "inserirPesquisaRequest")
        InserirPesquisaRequest inserirPesquisaRequest);

    /**
     * 
     * @param inserirChatRequest
     * @return
     *     returns ws.InserirChatResponse
     */
    @WebMethod
    @WebResult(name = "inserirChatResponse", targetNamespace = "http://www.batepapo.com/xml/users", partName = "inserirChatResponse")
    public InserirChatResponse inserirChat(
        @WebParam(name = "inserirChatRequest", targetNamespace = "http://www.batepapo.com/xml/users", partName = "inserirChatRequest")
        InserirChatRequest inserirChatRequest);

    /**
     * 
     * @param alterarUsuarioRequest
     * @return
     *     returns ws.AlterarUsuarioResponse
     */
    @WebMethod
    @WebResult(name = "alterarUsuarioResponse", targetNamespace = "http://www.batepapo.com/xml/users", partName = "alterarUsuarioResponse")
    public AlterarUsuarioResponse alterarUsuario(
        @WebParam(name = "alterarUsuarioRequest", targetNamespace = "http://www.batepapo.com/xml/users", partName = "alterarUsuarioRequest")
        AlterarUsuarioRequest alterarUsuarioRequest);

    /**
     * 
     * @param todosUsuarioRequest
     * @return
     *     returns ws.TodosUsuarioResponse
     */
    @WebMethod
    @WebResult(name = "todosUsuarioResponse", targetNamespace = "http://www.batepapo.com/xml/users", partName = "todosUsuarioResponse")
    public TodosUsuarioResponse todosUsuario(
        @WebParam(name = "todosUsuarioRequest", targetNamespace = "http://www.batepapo.com/xml/users", partName = "todosUsuarioRequest")
        Object todosUsuarioRequest);

    /**
     * 
     * @param inserirAcessoRequest
     * @return
     *     returns ws.InserirAcessoResponse
     */
    @WebMethod
    @WebResult(name = "inserirAcessoResponse", targetNamespace = "http://www.batepapo.com/xml/users", partName = "inserirAcessoResponse")
    public InserirAcessoResponse inserirAcesso(
        @WebParam(name = "inserirAcessoRequest", targetNamespace = "http://www.batepapo.com/xml/users", partName = "inserirAcessoRequest")
        InserirAcessoRequest inserirAcessoRequest);

}