
package com.batepapo.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="codUsuario1" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="codUsuario2" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="topico" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "codUsuario1",
    "codUsuario2",
    "topico"
})
@XmlRootElement(name = "inserirChatRequest")
public class InserirChatRequest {

    protected long codUsuario1;
    protected long codUsuario2;
    protected long topico;

    /**
     * Gets the value of the codUsuario1 property.
     * 
     */
    public long getCodUsuario1() {
        return codUsuario1;
    }

    /**
     * Sets the value of the codUsuario1 property.
     * 
     */
    public void setCodUsuario1(long value) {
        this.codUsuario1 = value;
    }

    /**
     * Gets the value of the codUsuario2 property.
     * 
     */
    public long getCodUsuario2() {
        return codUsuario2;
    }

    /**
     * Sets the value of the codUsuario2 property.
     * 
     */
    public void setCodUsuario2(long value) {
        this.codUsuario2 = value;
    }

    /**
     * Gets the value of the topico property.
     * 
     */
    public long getTopico() {
        return topico;
    }

    /**
     * Sets the value of the topico property.
     * 
     */
    public void setTopico(long value) {
        this.topico = value;
    }

}
