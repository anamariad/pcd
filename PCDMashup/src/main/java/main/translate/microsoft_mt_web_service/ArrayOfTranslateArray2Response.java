
package main.translate.microsoft_mt_web_service;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTranslateArray2Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTranslateArray2Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TranslateArray2Response" type="{http://schemas.datacontract.org/2004/07/Microsoft.MT.Web.Service.V2}TranslateArray2Response" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTranslateArray2Response", propOrder = {
    "translateArray2Response"
})
public class ArrayOfTranslateArray2Response {

    @XmlElement(name = "TranslateArray2Response", nillable = true)
    protected List<TranslateArray2Response> translateArray2Response;

    /**
     * Gets the value of the translateArray2Response property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the translateArray2Response property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTranslateArray2Response().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TranslateArray2Response }
     * 
     * 
     */
    public List<TranslateArray2Response> getTranslateArray2Response() {
        if (translateArray2Response == null) {
            translateArray2Response = new ArrayList<TranslateArray2Response>();
        }
        return this.translateArray2Response;
    }

}
