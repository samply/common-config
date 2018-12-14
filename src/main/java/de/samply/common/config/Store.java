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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{http://schema.samply.de/common}postgresql"/&gt;
 *         &lt;element name="security"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="hashAlgorithm" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *                   &lt;element name="rounds" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="postfix" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *                   &lt;element name="maxFailCounter" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
@XmlType(name = "", propOrder = {
    "postgresql",
    "security"
})
@XmlRootElement(name = "store", namespace = "http://schema.samply.de/config/Store")
public class Store {

    @XmlElement(required = true)
    protected Postgresql postgresql;
    @XmlElement(namespace = "http://schema.samply.de/config/Store", required = true)
    protected Store.Security security;

    /**
     * Gets the value of the postgresql property.
     * 
     * @return
     *     possible object is
     *     {@link Postgresql }
     *     
     */
    public Postgresql getPostgresql() {
        return postgresql;
    }

    /**
     * Sets the value of the postgresql property.
     * 
     * @param value
     *     allowed object is
     *     {@link Postgresql }
     *     
     */
    public void setPostgresql(Postgresql value) {
        this.postgresql = value;
    }

    /**
     * Gets the value of the security property.
     * 
     * @return
     *     possible object is
     *     {@link Store.Security }
     *     
     */
    public Store.Security getSecurity() {
        return security;
    }

    /**
     * Sets the value of the security property.
     * 
     * @param value
     *     allowed object is
     *     {@link Store.Security }
     *     
     */
    public void setSecurity(Store.Security value) {
        this.security = value;
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
     *         &lt;element name="hashAlgorithm" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
     *         &lt;element name="rounds" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
     *         &lt;element name="postfix" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
     *         &lt;element name="maxFailCounter" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
        "hashAlgorithm",
        "rounds",
        "postfix",
        "maxFailCounter"
    })
    public static class Security {

        @XmlElement(namespace = "http://schema.samply.de/config/Store", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String hashAlgorithm;
        @XmlElement(namespace = "http://schema.samply.de/config/Store")
        protected int rounds;
        @XmlElement(namespace = "http://schema.samply.de/config/Store", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String postfix;
        @XmlElement(namespace = "http://schema.samply.de/config/Store")
        protected int maxFailCounter;

        /**
         * Gets the value of the hashAlgorithm property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHashAlgorithm() {
            return hashAlgorithm;
        }

        /**
         * Sets the value of the hashAlgorithm property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHashAlgorithm(String value) {
            this.hashAlgorithm = value;
        }

        /**
         * Gets the value of the rounds property.
         * 
         */
        public int getRounds() {
            return rounds;
        }

        /**
         * Sets the value of the rounds property.
         * 
         */
        public void setRounds(int value) {
            this.rounds = value;
        }

        /**
         * Gets the value of the postfix property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPostfix() {
            return postfix;
        }

        /**
         * Sets the value of the postfix property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPostfix(String value) {
            this.postfix = value;
        }

        /**
         * Gets the value of the maxFailCounter property.
         * 
         */
        public int getMaxFailCounter() {
            return maxFailCounter;
        }

        /**
         * Sets the value of the maxFailCounter property.
         * 
         */
        public void setMaxFailCounter(int value) {
            this.maxFailCounter = value;
        }

    }

}
