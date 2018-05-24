//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2018.05.22 às 07:21:16 PM BRT 
//


package br.com.batepapo.batepapouserssoapwebservices.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de Chat complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Chat">
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
@XmlType(name = "Chat", propOrder = {
    "codUsuario1",
    "codUsuario2",
    "topico",
    "dataHora"
})
public class Chat {

    protected long codUsuario1;
    protected long codUsuario2;
    protected long topico;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataHora;

    /**
     * Obtém o valor da propriedade codUsuario1.
     * 
     */
    public long getCodUsuario1() {
        return codUsuario1;
    }

    /**
     * Define o valor da propriedade codUsuario1.
     * 
     */
    public void setCodUsuario1(long value) {
        this.codUsuario1 = value;
    }

    /**
     * Obtém o valor da propriedade codUsuario2.
     * 
     */
    public long getCodUsuario2() {
        return codUsuario2;
    }

    /**
     * Define o valor da propriedade codUsuario2.
     * 
     */
    public void setCodUsuario2(long value) {
        this.codUsuario2 = value;
    }

    /**
     * Obtém o valor da propriedade topico.
     * 
     */
    public long getTopico() {
        return topico;
    }

    /**
     * Define o valor da propriedade topico.
     * 
     */
    public void setTopico(long value) {
        this.topico = value;
    }

    /**
     * Obtém o valor da propriedade dataHora.
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
     * Define o valor da propriedade dataHora.
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
