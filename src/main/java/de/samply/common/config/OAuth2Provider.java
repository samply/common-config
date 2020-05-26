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
 * Java class for oAuth2Provider complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="oAuth2Provider"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="privateKey" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="publicKey" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="issuer" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "oAuth2Provider", namespace = "http://schema.samply.de/config/OAuth2Provider", propOrder = {
    "privateKey",
    "publicKey",
    "issuer"
})
public class OAuth2Provider {

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String privateKey;
  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String publicKey;
  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String issuer;

  /**
   * Gets the value of the privateKey property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getPrivateKey() {
    return privateKey;
  }

  /**
   * Sets the value of the privateKey property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setPrivateKey(String value) {
    this.privateKey = value;
  }

  /**
   * Gets the value of the publicKey property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getPublicKey() {
    return publicKey;
  }

  /**
   * Sets the value of the publicKey property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setPublicKey(String value) {
    this.publicKey = value;
  }

  /**
   * Gets the value of the issuer property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getIssuer() {
    return issuer;
  }

  /**
   * Sets the value of the issuer property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setIssuer(String value) {
    this.issuer = value;
  }

}
