
package main.translate.microsoft_mt_web_service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TranslateOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TranslateOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IncludeMultipleMTAlternatives" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ReservedFlags" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TranslateOptions", propOrder = {
    "category",
    "contentType",
    "includeMultipleMTAlternatives",
    "reservedFlags",
    "state",
    "uri",
    "user"
})
public class TranslateOptions {

    @XmlElementRef(name = "Category", namespace = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", type = JAXBElement.class, required = false)
    protected JAXBElement<String> category;
    @XmlElementRef(name = "ContentType", namespace = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contentType;
    @XmlElement(name = "IncludeMultipleMTAlternatives")
    protected Boolean includeMultipleMTAlternatives;
    @XmlElementRef(name = "ReservedFlags", namespace = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reservedFlags;
    @XmlElementRef(name = "State", namespace = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", type = JAXBElement.class, required = false)
    protected JAXBElement<String> state;
    @XmlElementRef(name = "Uri", namespace = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", type = JAXBElement.class, required = false)
    protected JAXBElement<String> uri;
    @XmlElementRef(name = "User", namespace = "http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2", type = JAXBElement.class, required = false)
    protected JAXBElement<String> user;

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCategory(JAXBElement<String> value) {
        this.category = value;
    }

    /**
     * Gets the value of the contentType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContentType() {
        return contentType;
    }

    /**
     * Sets the value of the contentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContentType(JAXBElement<String> value) {
        this.contentType = value;
    }

    /**
     * Gets the value of the includeMultipleMTAlternatives property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIncludeMultipleMTAlternatives() {
        return includeMultipleMTAlternatives;
    }

    /**
     * Sets the value of the includeMultipleMTAlternatives property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncludeMultipleMTAlternatives(Boolean value) {
        this.includeMultipleMTAlternatives = value;
    }

    /**
     * Gets the value of the reservedFlags property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReservedFlags() {
        return reservedFlags;
    }

    /**
     * Sets the value of the reservedFlags property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReservedFlags(JAXBElement<String> value) {
        this.reservedFlags = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setState(JAXBElement<String> value) {
        this.state = value;
    }

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUri(JAXBElement<String> value) {
        this.uri = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUser(JAXBElement<String> value) {
        this.user = value;
    }

}
