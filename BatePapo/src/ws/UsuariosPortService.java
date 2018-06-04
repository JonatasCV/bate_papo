
package ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "UsuariosPortService", targetNamespace = "http://www.batepapo.com/xml/users", wsdlLocation = "http://batepaposd.herokuapp.com/service/usuarioWsdl.wsdl")
public class UsuariosPortService
    extends Service
{

    private final static URL USUARIOSPORTSERVICE_WSDL_LOCATION;
    private final static WebServiceException USUARIOSPORTSERVICE_EXCEPTION;
    private final static QName USUARIOSPORTSERVICE_QNAME = new QName("http://www.batepapo.com/xml/users", "UsuariosPortService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://batepaposd.herokuapp.com/service/usuarioWsdl.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        USUARIOSPORTSERVICE_WSDL_LOCATION = url;
        USUARIOSPORTSERVICE_EXCEPTION = e;
    }

    public UsuariosPortService() {
        super(__getWsdlLocation(), USUARIOSPORTSERVICE_QNAME);
    }

    public UsuariosPortService(WebServiceFeature... features) {
        super(__getWsdlLocation(), USUARIOSPORTSERVICE_QNAME, features);
    }

    public UsuariosPortService(URL wsdlLocation) {
        super(wsdlLocation, USUARIOSPORTSERVICE_QNAME);
    }

    public UsuariosPortService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, USUARIOSPORTSERVICE_QNAME, features);
    }

    public UsuariosPortService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UsuariosPortService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UsuariosPort
     */
    @WebEndpoint(name = "UsuariosPortSoap11")
    public UsuariosPort getUsuariosPortSoap11() {
        return super.getPort(new QName("http://www.batepapo.com/xml/users", "UsuariosPortSoap11"), UsuariosPort.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UsuariosPort
     */
    @WebEndpoint(name = "UsuariosPortSoap11")
    public UsuariosPort getUsuariosPortSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.batepapo.com/xml/users", "UsuariosPortSoap11"), UsuariosPort.class, features);
    }

    private static URL __getWsdlLocation() {
        if (USUARIOSPORTSERVICE_EXCEPTION!= null) {
            throw USUARIOSPORTSERVICE_EXCEPTION;
        }
        return USUARIOSPORTSERVICE_WSDL_LOCATION;
    }

}
