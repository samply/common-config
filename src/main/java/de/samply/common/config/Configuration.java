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
import javax.xml.bind.annotation.XmlType;


/**
 * Java class for Configuration complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Configuration"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Proxy" type="{http://schema.samply.de/common}Proxy"/&gt;
 *         &lt;element name="Keystore" type="{http://schema.samply.de/common}Keystore"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Configuration", propOrder = {
    "proxy",
    "keystore"
})
public class Configuration {

  @XmlElement(name = "Proxy", required = true)
  protected Proxy proxy;
  @XmlElement(name = "Keystore", required = true)
  protected Keystore keystore;

  /**
   * Gets the value of the proxy property.
   *
   * @return
   *     possible object is
   *     {@link Proxy }
   *
   */
  public Proxy getProxy() {
    return proxy;
  }

  /**
   * Sets the value of the proxy property.
   *
   * @param value
   *     allowed object is
   *     {@link Proxy }
   *
   */
  public void setProxy(Proxy value) {
    this.proxy = value;
  }

  /**
   * Gets the value of the keystore property.
   *
   * @return
   *     possible object is
   *     {@link Keystore }
   *
   */
  public Keystore getKeystore() {
    return keystore;
  }

  /**
   * Sets the value of the keystore property.
   *
   * @param value
   *     allowed object is
   *     {@link Keystore }
   *
   */
  public void setKeystore(Keystore value) {
    this.keystore = value;
  }

}
