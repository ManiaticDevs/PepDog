//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.02.11 at 12:13:02 PM GMT 
//


package net.oikmo.toolbox.rbxl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}Item"/>
 *         &lt;element name="External" type="{http://www.w3.org/2001/XMLSchema}ID"/>
 *         &lt;element name="DeleteItem" type="{http://www.w3.org/2001/XMLSchema}ID"/>
 *       &lt;/choice>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}int" default="3" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "itemOrExternalOrDeleteItem"
})
@XmlRootElement(name = "roblox")
public class Roblox {

    @XmlElementRefs({
        @XmlElementRef(name = "Item", type = Item.class, required = false),
        @XmlElementRef(name = "DeleteItem", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "External", type = JAXBElement.class, required = false)
    })
    protected List<Object> itemOrExternalOrDeleteItem;
    @XmlAttribute(name = "version")
    protected Integer version;

    /**
     * Gets the value of the itemOrExternalOrDeleteItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemOrExternalOrDeleteItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemOrExternalOrDeleteItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<Object> getItemOrExternalOrDeleteItem() {
        if (itemOrExternalOrDeleteItem == null) {
            itemOrExternalOrDeleteItem = new ArrayList<Object>();
        }
        return this.itemOrExternalOrDeleteItem;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getVersion() {
        if (version == null) {
            return  3;
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVersion(Integer value) {
        this.version = value;
    }

}
