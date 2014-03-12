
package main.translate.v2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import main.translate.microsoft_mt_web_service.ArrayOfTranslation;
import main.translate.microsoft_mt_web_service.TranslateOptions;


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
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="translations" type="{http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2}ArrayOfTranslation" minOccurs="0"/>
 *         &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="to" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="options" type="{http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2}TranslateOptions" minOccurs="0"/>
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
    "appId",
    "translations",
    "from",
    "to",
    "options"
})
@XmlRootElement(name = "AddTranslationArray")
public class AddTranslationArray {

    @XmlElementRef(name = "appId", namespace = "http://api.microsofttranslator.com/V2", type = JAXBElement.class, required = false)
    protected JAXBElement<String> appId;
    @XmlElementRef(name = "translations", namespace = "http://api.microsofttranslator.com/V2", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfTranslation> translations;
    @XmlElementRef(name = "from", namespace = "http://api.microsofttranslator.com/V2", type = JAXBElement.class, required = false)
    protected JAXBElement<String> from;
    @XmlElementRef(name = "to", namespace = "http://api.microsofttranslator.com/V2", type = JAXBElement.class, required = false)
    protected JAXBElement<String> to;
    @XmlElementRef(name = "options", namespace = "http://api.microsofttranslator.com/V2", type = JAXBElement.class, required = false)
    protected JAXBElement<TranslateOptions> options;

    /**
     * Gets the value of the appId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAppId() {
        return appId;
    }

    /**
     * Sets the value of the appId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAppId(JAXBElement<String> value) {
        this.appId = value;
    }

    /**
     * Gets the value of the translations property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTranslation }{@code >}
     *     
     */
    public JAXBElement<ArrayOfTranslation> getTranslations() {
        return translations;
    }

    /**
     * Sets the value of the translations property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTranslation }{@code >}
     *     
     */
    public void setTranslations(JAXBElement<ArrayOfTranslation> value) {
        this.translations = value;
    }

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFrom(JAXBElement<String> value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTo(JAXBElement<String> value) {
        this.to = value;
    }

    /**
     * Gets the value of the options property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TranslateOptions }{@code >}
     *     
     */
    public JAXBElement<TranslateOptions> getOptions() {
        return options;
    }

    /**
     * Sets the value of the options property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TranslateOptions }{@code >}
     *     
     */
    public void setOptions(JAXBElement<TranslateOptions> value) {
        this.options = value;
    }

}