package de.samply.common.config;

import de.samply.common.config.adapters.UrlAdapter;
import java.net.URL;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Java class for HostAuth complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HostAuth"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="Url" type="{http://schema.samply.de/common}Url" minOccurs="0"/&gt;
 *         &lt;element name="Username" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "HostAuth",
    propOrder = {})
public class HostAuth {

  @XmlElement(name = "Url", type = String.class)
  @XmlJavaTypeAdapter(UrlAdapter.class)
  @XmlSchemaType(name = "token")
  protected URL url;

  @XmlElement(name = "Username")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String username;

  @XmlElement(name = "Password")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String password;

  /**
   * Gets the value of the url property.
   *
   * @return possible object is {@link String }
   */
  public URL getUrl() {
    return url;
  }

  /**
   * Sets the value of the url property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUrl(URL value) {
    this.url = value;
  }

  /**
   * Gets the value of the username property.
   *
   * @return possible object is {@link String }
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the value of the username property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUsername(String value) {
    this.username = value;
  }

  /**
   * Gets the value of the password property.
   *
   * @return possible object is {@link String }
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the value of the password property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPassword(String value) {
    this.password = value;
  }
}
