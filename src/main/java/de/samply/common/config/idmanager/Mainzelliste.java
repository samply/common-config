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

import java.net.URL;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.samply.common.config.adapters.URLAdapter;


/**
 * <p>Java class for Mainzelliste complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Mainzelliste"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;group ref="{http://schema.samply.de/id-manager}urlKey"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Mainzelliste", propOrder = {
    "url",
    "apiKey"
})
public class Mainzelliste {

    @XmlElement(name = "Url", required = true, type = String.class)
    @XmlJavaTypeAdapter(URLAdapter.class)
    @XmlSchemaType(name = "token")
    protected URL url;
    @XmlElement(name = "ApiKey", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String apiKey;

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public URL getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(URL value) {
        this.url = value;
    }

    /**
     * Gets the value of the apiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Sets the value of the apiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiKey(String value) {
        this.apiKey = value;
    }

}
