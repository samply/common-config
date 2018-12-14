/*
 * Copyright (C) 2015 Working Group on Joint Research, University Medical Center Mainz
 * Copyright (C) since 2016 The Samply Community
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 *
 * Additional permission under GNU GPL version 3 section 7:
 *
 * If you modify this Program, or any covered work, by linking or combining it
 * with Jersey (https://jersey.java.net) (or a modified version of that
 * library), containing parts covered by the terms of the General Public
 * License, version 2.0, the licensors of this Program grant you additional
 * permission to convey the resulting work.
 */

package de.samply.common.config.idmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.samply.common.config.Log;


/**
 * <p>Java class for ID-Manager complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ID-Manager"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Dist" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="InstanceID" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="Debug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Log" type="{http://schema.samply.de/common}Log" minOccurs="0"/&gt;
 *         &lt;element name="Servers" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Server" type="{http://schema.samply.de/id-manager}Server" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ControlNumberGenerators" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ControlNumberGenerator" type="{http://schema.samply.de/id-manager}ControlNumberGenerator" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Mainzelliste" type="{http://schema.samply.de/id-manager}Mainzelliste"/&gt;
 *         &lt;element name="SplitDates"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="SplitDate" type="{http://schema.samply.de/id-manager}SplitDate" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID-Manager", propOrder = {
    "dist",
    "instanceID",
    "debug",
    "log",
    "servers",
    "controlNumberGenerators",
    "mainzelliste",
    "splitDates"
})
public class IDManager {

    @XmlElement(name = "Dist", required = true, defaultValue = "Lokales Identit\u00e4tsmanagement der CCP-IT")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String dist;
    @XmlElement(name = "InstanceID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String instanceID;
    @XmlElement(name = "Debug")
    protected Boolean debug;
    @XmlElement(name = "Log")
    protected Log log;
    @XmlElement(name = "Servers")
    protected IDManager.Servers servers;
    @XmlElement(name = "ControlNumberGenerators")
    protected IDManager.ControlNumberGenerators controlNumberGenerators;
    @XmlElement(name = "Mainzelliste", required = true)
    protected Mainzelliste mainzelliste;
    @XmlElement(name = "SplitDates", required = true)
    protected IDManager.SplitDates splitDates;

    /**
     * Gets the value of the dist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDist() {
        return dist;
    }

    /**
     * Sets the value of the dist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDist(String value) {
        this.dist = value;
    }

    /**
     * Gets the value of the instanceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceID() {
        return instanceID;
    }

    /**
     * Sets the value of the instanceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceID(String value) {
        this.instanceID = value;
    }

    /**
     * Gets the value of the debug property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebug() {
        return debug;
    }

    /**
     * Sets the value of the debug property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebug(Boolean value) {
        this.debug = value;
    }

    /**
     * Gets the value of the log property.
     * 
     * @return
     *     possible object is
     *     {@link Log }
     *     
     */
    public Log getLog() {
        return log;
    }

    /**
     * Sets the value of the log property.
     * 
     * @param value
     *     allowed object is
     *     {@link Log }
     *     
     */
    public void setLog(Log value) {
        this.log = value;
    }

    /**
     * Gets the value of the servers property.
     * 
     * @return
     *     possible object is
     *     {@link IDManager.Servers }
     *     
     */
    public IDManager.Servers getServers() {
        return servers;
    }

    /**
     * Sets the value of the servers property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDManager.Servers }
     *     
     */
    public void setServers(IDManager.Servers value) {
        this.servers = value;
    }

    /**
     * Gets the value of the controlNumberGenerators property.
     * 
     * @return
     *     possible object is
     *     {@link IDManager.ControlNumberGenerators }
     *     
     */
    public IDManager.ControlNumberGenerators getControlNumberGenerators() {
        return controlNumberGenerators;
    }

    /**
     * Sets the value of the controlNumberGenerators property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDManager.ControlNumberGenerators }
     *     
     */
    public void setControlNumberGenerators(IDManager.ControlNumberGenerators value) {
        this.controlNumberGenerators = value;
    }

    /**
     * Gets the value of the mainzelliste property.
     * 
     * @return
     *     possible object is
     *     {@link Mainzelliste }
     *     
     */
    public Mainzelliste getMainzelliste() {
        return mainzelliste;
    }

    /**
     * Sets the value of the mainzelliste property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mainzelliste }
     *     
     */
    public void setMainzelliste(Mainzelliste value) {
        this.mainzelliste = value;
    }

    /**
     * Gets the value of the splitDates property.
     * 
     * @return
     *     possible object is
     *     {@link IDManager.SplitDates }
     *     
     */
    public IDManager.SplitDates getSplitDates() {
        return splitDates;
    }

    /**
     * Sets the value of the splitDates property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDManager.SplitDates }
     *     
     */
    public void setSplitDates(IDManager.SplitDates value) {
        this.splitDates = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ControlNumberGenerator" type="{http://schema.samply.de/id-manager}ControlNumberGenerator" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "controlNumberGenerators"
    })
    public static class ControlNumberGenerators {

        @XmlElement(name = "ControlNumberGenerator")
        protected List<ControlNumberGenerator> controlNumberGenerators;

        /**
         * Gets the value of the controlNumberGenerators property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the controlNumberGenerators property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getControlNumberGenerators().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ControlNumberGenerator }
         * 
         * 
         */
        public List<ControlNumberGenerator> getControlNumberGenerators() {
            if (controlNumberGenerators == null) {
                controlNumberGenerators = new ArrayList<ControlNumberGenerator>();
            }
            return this.controlNumberGenerators;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Server" type="{http://schema.samply.de/id-manager}Server" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "servers"
    })
    public static class Servers {

        @XmlElement(name = "Server")
        protected List<Server> servers;

        /**
         * Gets the value of the servers property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the servers property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getServers().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Server }
         * 
         * 
         */
        public List<Server> getServers() {
            if (servers == null) {
                servers = new ArrayList<Server>();
            }
            return this.servers;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="SplitDate" type="{http://schema.samply.de/id-manager}SplitDate" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "splitDates"
    })
    public static class SplitDates {

        @XmlElement(name = "SplitDate")
        protected List<SplitDate> splitDates;

        /**
         * Gets the value of the splitDates property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the splitDates property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSplitDates().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SplitDate }
         * 
         * 
         */
        public List<SplitDate> getSplitDates() {
            if (splitDates == null) {
                splitDates = new ArrayList<SplitDate>();
            }
            return this.splitDates;
        }

    }

}
