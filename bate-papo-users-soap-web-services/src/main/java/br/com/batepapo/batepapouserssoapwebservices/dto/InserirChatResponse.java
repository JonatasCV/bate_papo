//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.05.13 at 08:34:01 PM BRT 
//


package br.com.batepapo.batepapouserssoapwebservices.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="dataHora" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
    "topico",
    "dataHora"
})
@XmlRootElement(name = "inserirChatResponse")
public class InserirChatResponse {

    protected long codUsuario1;
    protected long codUsuario2;
    protected long topico;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataHora;

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

    /**
     * Gets the value of the dataHora property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataHora() {
        return dataHora;
    }

    /**
     * Sets the value of the dataHora property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataHora(XMLGregorianCalendar value) {
        this.dataHora = value;
    }

}
