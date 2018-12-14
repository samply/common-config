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

package de.samply.common.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Proxy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Proxy"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="HTTP" type="{http://schema.samply.de/common}HostAuth" minOccurs="0"/&gt;
 *         &lt;element name="HTTPS" type="{http://schema.samply.de/common}HostAuth" minOccurs="0"/&gt;
 *         &lt;element name="Realm" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="NoProxyHosts" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element name="Host" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Proxy", propOrder = {

})
public class Proxy {

    @XmlElement(name = "HTTP")
    protected HostAuth http;
    @XmlElement(name = "HTTPS")
    protected HostAuth https;
    @XmlElement(name = "Realm", required = true)
    protected String realm;
    @XmlElement(name = "NoProxyHosts")
    protected Proxy.NoProxyHosts noProxyHosts;

    /**
     * Gets the value of the http property.
     * 
     * @return
     *     possible object is
     *     {@link HostAuth }
     *     
     */
    public HostAuth getHTTP() {
        return http;
    }

    /**
     * Sets the value of the http property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostAuth }
     *     
     */
    public void setHTTP(HostAuth value) {
        this.http = value;
    }

    /**
     * Gets the value of the https property.
     * 
     * @return
     *     possible object is
     *     {@link HostAuth }
     *     
     */
    public HostAuth getHTTPS() {
        return https;
    }

    /**
     * Sets the value of the https property.
     * 
     * @param value
     *     allowed object is
     *     {@link HostAuth }
     *     
     */
    public void setHTTPS(HostAuth value) {
        this.https = value;
    }

    /**
     * Gets the value of the realm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRealm() {
        return realm;
    }

    /**
     * Sets the value of the realm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRealm(String value) {
        this.realm = value;
    }

    /**
     * Gets the value of the noProxyHosts property.
     * 
     * @return
     *     possible object is
     *     {@link Proxy.NoProxyHosts }
     *     
     */
    public Proxy.NoProxyHosts getNoProxyHosts() {
        return noProxyHosts;
    }

    /**
     * Sets the value of the noProxyHosts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Proxy.NoProxyHosts }
     *     
     */
    public void setNoProxyHosts(Proxy.NoProxyHosts value) {
        this.noProxyHosts = value;
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
     *       &lt;all&gt;
     *         &lt;element name="Host" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
     *       &lt;/all&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class NoProxyHosts {

        @XmlElement(name = "Host")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String host;

        /**
         * Gets the value of the host property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHost() {
            return host;
        }

        /**
         * Sets the value of the host property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHost(String value) {
            this.host = value;
        }

    }

}
