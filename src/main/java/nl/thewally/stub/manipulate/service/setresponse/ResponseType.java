//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.17 at 09:58:42 AM CET 
//


package nl.thewally.stub.manipulate.service.setresponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requestTarget" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="responseXml" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseType", propOrder = {
    "requestTarget",
    "responseXml"
})
public class ResponseType {

    @XmlElement(required = true)
    protected String requestTarget;
    @XmlElement(required = true)
    protected String responseXml;

    /**
     * Gets the value of the requestTarget property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestTarget() {
        return requestTarget;
    }

    /**
     * Sets the value of the requestTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestTarget(String value) {
        this.requestTarget = value;
    }

    /**
     * Gets the value of the responseXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseXml() {
        return responseXml;
    }

    /**
     * Sets the value of the responseXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseXml(String value) {
        this.responseXml = value;
    }

}
