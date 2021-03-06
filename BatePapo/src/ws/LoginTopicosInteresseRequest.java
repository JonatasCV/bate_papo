
package ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codUsuario" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="topicos" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "codUsuario",
    "topicos"
})
@XmlRootElement(name = "loginTopicosInteresseRequest")
public class LoginTopicosInteresseRequest {

    protected long codUsuario;
    @XmlElement(type = Long.class)
    protected List<Long> topicos;

    /**
     * Gets the value of the codUsuario property.
     * 
     */
    public long getCodUsuario() {
        return codUsuario;
    }

    /**
     * Sets the value of the codUsuario property.
     * 
     */
    public void setCodUsuario(long value) {
        this.codUsuario = value;
    }

    /**
     * Gets the value of the topicos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topicos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTopicos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getTopicos() {
        if (topicos == null) {
            topicos = new ArrayList<Long>();
        }
        return this.topicos;
    }

}
