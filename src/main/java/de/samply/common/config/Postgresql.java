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
 * Java class for postgresql complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="postgresql"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="host" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="database" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "postgresql", propOrder = {
    "host",
    "database",
    "username",
    "password"
})
public class Postgresql {

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String host;
  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String database;
  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String username;
  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String password;

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

  /**
   * Gets the value of the database property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getDatabase() {
    return database;
  }

  /**
   * Sets the value of the database property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setDatabase(String value) {
    this.database = value;
  }

  /**
   * Gets the value of the username property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the value of the username property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setUsername(String value) {
    this.username = value;
  }

  /**
   * Gets the value of the password property.
   *
   * @return
   *     possible object is
   *     {@link String }
   *
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the value of the password property.
   *
   * @param value
   *     allowed object is
   *     {@link String }
   *
   */
  public void setPassword(String value) {
    this.password = value;
  }

}
