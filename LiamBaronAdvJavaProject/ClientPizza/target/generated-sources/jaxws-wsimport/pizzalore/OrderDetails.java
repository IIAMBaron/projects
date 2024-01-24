
package pizzalore;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="orderDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hashID" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="hashProdQuantity" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orderDetails", propOrder = {
    "orderID",
    "hashID",
    "hashProdQuantity"
})
public class OrderDetails {

    protected int orderID;
    protected Object hashID;
    protected Object hashProdQuantity;

    /**
     * Gets the value of the orderID property.
     * 
     * @return 
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Sets the value of the orderID property.
     * 
     * @param value
     */
    public void setOrderID(int value) {
        this.orderID = value;
    }

    /**
     * Gets the value of the hashID property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getHashID() {
        return hashID;
    }

    /**
     * Sets the value of the hashID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setHashID(Object value) {
        this.hashID = value;
    }

    /**
     * Gets the value of the hashProdQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getHashProdQuantity() {
        return hashProdQuantity;
    }

    /**
     * Sets the value of the hashProdQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setHashProdQuantity(Object value) {
        this.hashProdQuantity = value;
    }

}
