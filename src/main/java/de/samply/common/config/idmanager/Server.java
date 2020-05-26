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


/**
 * Java class for Server complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Server"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="ApiKey" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="Permissions" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Permission" type="{http://schema.samply.de/id-manager}Permission" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AllowedRemoteAdresses"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}token" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Server", propOrder = {

})
public class Server {

  @XmlElement(name = "ApiKey", required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String apiKey;
  @XmlElement(name = "Permissions")
  protected Server.Permissions permissions;
  @XmlElement(name = "AllowedRemoteAdresses", required = true)
  protected Server.AllowedRemoteAdresses allowedRemoteAdresses;

  /**
   * Gets the value of the apiKey property.
   *
   * @return possible object is {@link String }
   */
  public String getApiKey() {
    return apiKey;
  }

  /**
   * Sets the value of the apiKey property.
   *
   * @param value allowed object is {@link String }
   */
  public void setApiKey(String value) {
    this.apiKey = value;
  }

  /**
   * Gets the value of the permissions property.
   *
   * @return possible object is {@link Server.Permissions }
   */
  public Server.Permissions getPermissions() {
    return permissions;
  }

  /**
   * Sets the value of the permissions property.
   *
   * @param value allowed object is {@link Server.Permissions }
   */
  public void setPermissions(Server.Permissions value) {
    this.permissions = value;
  }

  /**
   * Gets the value of the allowedRemoteAdresses property.
   *
   * @return possible object is {@link Server.AllowedRemoteAdresses }
   */
  public Server.AllowedRemoteAdresses getAllowedRemoteAdresses() {
    return allowedRemoteAdresses;
  }

  /**
   * Sets the value of the allowedRemoteAdresses property.
   *
   * @param value allowed object is {@link Server.AllowedRemoteAdresses }
   */
  public void setAllowedRemoteAdresses(Server.AllowedRemoteAdresses value) {
    this.allowedRemoteAdresses = value;
  }


  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}token" maxOccurs="unbounded"/&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "", propOrder = {
      "adresses"
  })
  public static class AllowedRemoteAdresses {

    @XmlElement(name = "Address", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected List<String> adresses;

    /**
     * Gets the value of the adresses property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the adresses property.
     *
     * <p>For example, to add a new item, do as follows:
     * <pre>
     *    getAdresses().add(newItem);
     * </pre>
     *
     *
     * <p>Objects of the following type(s) are allowed in the list {@link String }
     */
    public List<String> getAdresses() {
      if (adresses == null) {
        adresses = new ArrayList<String>();
      }
      return this.adresses;
    }

  }


  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="Permission" type="{http://schema.samply.de/id-manager}Permission" maxOccurs="unbounded" minOccurs="0"/&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(name = "", propOrder = {
      "permission"
  })
  public static class Permissions {

    @XmlElement(name = "Permission")
    @XmlSchemaType(name = "string")
    protected List<Permission> permission;

    /**
     * Gets the value of the permission property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the permission property.
     *
     * <p>For example, to add a new item, do as follows:
     * <pre>
     *    getPermission().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link Permission }
     */
    public List<Permission> getPermission() {
      if (permission == null) {
        permission = new ArrayList<Permission>();
      }
      return this.permission;
    }

  }

}
