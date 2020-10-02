package de.samply.common.config.idmanager;

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
 * Java class for ControlNumberGenerator complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ControlNumberGenerator"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IDType" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="AddInstance" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;group ref="{http://schema.samply.de/id-manager}urlKey"/&gt;
 *           &lt;element name="Key" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "ControlNumberGenerator",
    propOrder = {"idType", "addInstance", "url", "apiKey", "key"})
public class ControlNumberGenerator {

  @XmlElement(name = "IDType", required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String idType;

  @XmlElement(name = "AddInstance")
  protected Boolean addInstance;

  @XmlElement(name = "Url", type = String.class)
  @XmlJavaTypeAdapter(UrlAdapter.class)
  @XmlSchemaType(name = "token")
  protected URL url;

  @XmlElement(name = "ApiKey")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String apiKey;

  @XmlElement(name = "Key")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String key;

  /**
   * Gets the value of the idType property.
   *
   * @return possible object is {@link String }
   */
  public String getIdType() {
    return idType;
  }

  /**
   * Sets the value of the idType property.
   *
   * @param value allowed object is {@link String }
   */
  public void setIdType(String value) {
    this.idType = value;
  }

  /**
   * Gets the value of the addInstance property.
   *
   * @return possible object is {@link Boolean }
   */
  public Boolean isAddInstance() {
    return addInstance;
  }

  /**
   * Sets the value of the addInstance property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setAddInstance(Boolean value) {
    this.addInstance = value;
  }

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
   * Gets the value of the key property.
   *
   * @return possible object is {@link String }
   */
  public String getKey() {
    return key;
  }

  /**
   * Sets the value of the key property.
   *
   * @param value allowed object is {@link String }
   */
  public void setKey(String value) {
    this.key = value;
  }
}
