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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "Configuration",
    propOrder = {"proxy", "keystore"})
public class Configuration {

  @XmlElement(name = "Proxy", required = true)
  protected Proxy proxy;

  @XmlElement(name = "Keystore", required = true)
  protected Keystore keystore;

  /**
   * Gets the value of the proxy property.
   *
   * @return possible object is {@link Proxy }
   */
  public Proxy getProxy() {
    return proxy;
  }

  /**
   * Sets the value of the proxy property.
   *
   * @param value allowed object is {@link Proxy }
   */
  public void setProxy(Proxy value) {
    this.proxy = value;
  }

  /**
   * Gets the value of the keystore property.
   *
   * @return possible object is {@link Keystore }
   */
  public Keystore getKeystore() {
    return keystore;
  }

  /**
   * Sets the value of the keystore property.
   *
   * @param value allowed object is {@link Keystore }
   */
  public void setKeystore(Keystore value) {
    this.keystore = value;
  }
}
