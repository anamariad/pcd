
package main.translate.v2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import main.translate.microsoft_mt_web_service.ArrayOfTranslateArray2Response;


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
 *         &lt;element name="TranslateArray2Result" type="{http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2}ArrayOfTranslateArray2Response" minOccurs="0"/>
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
    "translateArray2Result"
})
@XmlRootElement(name = "TranslateArray2Response")
public class TranslateArray2Response {

    @XmlElementRef(name = "TranslateArray2Result", namespace = "http://api.microsofttranslator.com/V2", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfTranslateArray2Response> translateArray2Result;

    /**
     * Gets the value of the translateArray2Result property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTranslateArray2Response }{@code >}
     *     
     */
    public JAXBElement<ArrayOfTranslateArray2Response> getTranslateArray2Result() {
        return translateArray2Result;
    }

    /**
     * Sets the value of the translateArray2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTranslateArray2Response }{@code >}
     *     
     */
    public void setTranslateArray2Result(JAXBElement<ArrayOfTranslateArray2Response> value) {
        this.translateArray2Result = value;
    }

}
