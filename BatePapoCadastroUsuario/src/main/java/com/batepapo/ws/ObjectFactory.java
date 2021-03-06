
package com.batepapo.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.batepapo.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TodosUsuarioRequest_QNAME = new QName("http://www.batepapo.com/xml/users", "todosUsuarioRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.batepapo.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AlterarUsuarioResponse }
     * 
     */
    public AlterarUsuarioResponse createAlterarUsuarioResponse() {
        return new AlterarUsuarioResponse();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link TodosUsuarioResponse }
     * 
     */
    public TodosUsuarioResponse createTodosUsuarioResponse() {
        return new TodosUsuarioResponse();
    }

    /**
     * Create an instance of {@link InserirChatRequest }
     * 
     */
    public InserirChatRequest createInserirChatRequest() {
        return new InserirChatRequest();
    }

    /**
     * Create an instance of {@link IncluirUsuarioResponse }
     * 
     */
    public IncluirUsuarioResponse createIncluirUsuarioResponse() {
        return new IncluirUsuarioResponse();
    }

    /**
     * Create an instance of {@link InserirAcessoResponse }
     * 
     */
    public InserirAcessoResponse createInserirAcessoResponse() {
        return new InserirAcessoResponse();
    }

    /**
     * Create an instance of {@link InserirPesquisaResponse }
     * 
     */
    public InserirPesquisaResponse createInserirPesquisaResponse() {
        return new InserirPesquisaResponse();
    }

    /**
     * Create an instance of {@link InserirAcessoRequest }
     * 
     */
    public InserirAcessoRequest createInserirAcessoRequest() {
        return new InserirAcessoRequest();
    }

    /**
     * Create an instance of {@link AlterarUsuarioRequest }
     * 
     */
    public AlterarUsuarioRequest createAlterarUsuarioRequest() {
        return new AlterarUsuarioRequest();
    }

    /**
     * Create an instance of {@link ExcluirUsuarioResponse }
     * 
     */
    public ExcluirUsuarioResponse createExcluirUsuarioResponse() {
        return new ExcluirUsuarioResponse();
    }

    /**
     * Create an instance of {@link IncluirUsuarioRequest }
     * 
     */
    public IncluirUsuarioRequest createIncluirUsuarioRequest() {
        return new IncluirUsuarioRequest();
    }

    /**
     * Create an instance of {@link ExcluirUsuarioRequest }
     * 
     */
    public ExcluirUsuarioRequest createExcluirUsuarioRequest() {
        return new ExcluirUsuarioRequest();
    }

    /**
     * Create an instance of {@link InserirPesquisaRequest }
     * 
     */
    public InserirPesquisaRequest createInserirPesquisaRequest() {
        return new InserirPesquisaRequest();
    }

    /**
     * Create an instance of {@link InserirChatResponse }
     * 
     */
    public InserirChatResponse createInserirChatResponse() {
        return new InserirChatResponse();
    }

    /**
     * Create an instance of {@link Chat }
     * 
     */
    public Chat createChat() {
        return new Chat();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.batepapo.com/xml/users", name = "todosUsuarioRequest")
    public JAXBElement<Object> createTodosUsuarioRequest(Object value) {
        return new JAXBElement<Object>(_TodosUsuarioRequest_QNAME, Object.class, null, value);
    }

}
