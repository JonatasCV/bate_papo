
package ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Usuario complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Usuario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codUsuario" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="iPaddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Usuario", propOrder = {
    "codUsuario",
    "nome",
    "iPaddress"
})
public class Usuario {

    protected long codUsuario;
    @XmlElement(required = true)
    protected String nome;
    @XmlElement(required = true)
    protected String iPaddress;

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
     * Gets the value of the nome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the value of the nome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Gets the value of the iPaddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIPaddress() {
        return iPaddress;
    }

    /**
     * Sets the value of the iPaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIPaddress(String value) {
        this.iPaddress = value;
    }

}
