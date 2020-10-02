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
 * Java class for Mainzelliste complex type.
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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "Mainzelliste",
    propOrder = {"url", "apiKey"})
public class Mainzelliste {

  @XmlElement(name = "Url", required = true, type = String.class)
  @XmlJavaTypeAdapter(UrlAdapter.class)
  @XmlSchemaType(name = "token")
  protected URL url;

  @XmlElement(name = "ApiKey", required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String apiKey;

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
}
