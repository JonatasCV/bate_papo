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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de Usuario complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
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
     * Obtém o valor da propriedade codUsuario.
     * 
     */
    public long getCodUsuario() {
        return codUsuario;
    }

    /**
     * Define o valor da propriedade codUsuario.
     * 
     */
    public void setCodUsuario(long value) {
        this.codUsuario = value;
    }

    /**
     * Obtém o valor da propriedade nome.
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
     * Define o valor da propriedade nome.
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
     * Obtém o valor da propriedade iPaddress.
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
     * Define o valor da propriedade iPaddress.
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
