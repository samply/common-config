package de.samply.common.config;

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
 * Java class for oAuth2Client complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="oAuth2Client"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="host" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="hostPublicKey" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *         &lt;element name="clientId" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="clientSecret" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="additionalHostnames" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="hostname" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="host" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *                             &lt;element name="ifServernameEquals" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="externalIP" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "oAuth2Client",
    namespace = "http://schema.samply.de/config/OAuth2Client",
    propOrder = {
      "host",
      "hostPublicKey",
      "clientId",
      "clientSecret",
      "additionalHostnames",
      "externalIP",
      "useSamplyAuth",
      "realm"
    })
public class OAuth2Client {

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String host;

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String hostPublicKey;

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String clientId;

  @XmlElement(required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String clientSecret;

  protected OAuth2Client.AdditionalHostnames additionalHostnames;

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String externalIP;

  @XmlElement(required = true)
  @XmlSchemaType(name = "boolean")
  protected boolean useSamplyAuth;

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String realm;

  /**
   * Gets the value of the host property.
   *
   * @return possible object is {@link String }
   */
  public String getHost() {
    return host;
  }

  /**
   * Sets the value of the host property.
   *
   * @param value allowed object is {@link String }
   */
  public void setHost(String value) {
    this.host = value;
  }

  /**
   * Gets the value of the hostPublicKey property.
   *
   * @return possible object is {@link String }
   */
  public String getHostPublicKey() {
    return hostPublicKey;
  }

  /**
   * Sets the value of the hostPublicKey property.
   *
   * @param value allowed object is {@link String }
   */
  public void setHostPublicKey(String value) {
    this.hostPublicKey = value;
  }

  /**
   * Gets the value of the clientId property.
   *
   * @return possible object is {@link String }
   */
  public String getClientId() {
    return clientId;
  }

  /**
   * Sets the value of the clientId property.
   *
   * @param value allowed object is {@link String }
   */
  public void setClientId(String value) {
    this.clientId = value;
  }

  /**
   * Gets the value of the clientSecret property.
   *
   * @return possible object is {@link String }
   */
  public String getClientSecret() {
    return clientSecret;
  }

  /**
   * Sets the value of the clientSecret property.
   *
   * @param value allowed object is {@link String }
   */
  public void setClientSecret(String value) {
    this.clientSecret = value;
  }

  /**
   * Gets the value of the additionalHostnames property.
   *
   * @return possible object is {@link OAuth2Client.AdditionalHostnames }
   */
  public OAuth2Client.AdditionalHostnames getAdditionalHostnames() {
    return additionalHostnames;
  }

  /**
   * Sets the value of the additionalHostnames property.
   *
   * @param value allowed object is {@link OAuth2Client.AdditionalHostnames }
   */
  public void setAdditionalHostnames(OAuth2Client.AdditionalHostnames value) {
    this.additionalHostnames = value;
  }

  /**
   * Gets the value of the externalIP property.
   *
   * @return possible object is {@link String }
   */
  public String getExternalIP() {
    return externalIP;
  }

  /**
   * Sets the value of the externalIP property.
   *
   * @param value allowed object is {@link String }
   */
  public void setExternalIP(String value) {
    this.externalIP = value;
  }

  public boolean isUseSamplyAuth() {
    return useSamplyAuth;
  }

  public void setUseSamplyAuth(boolean useSamplyAuth) {
    this.useSamplyAuth = useSamplyAuth;
  }

  public String getRealm() {
    return realm;
  }

  public void setRealm(String realm) {
    this.realm = realm;
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
   *         &lt;element name="hostname" maxOccurs="unbounded" minOccurs="0"&gt;
   *           &lt;complexType&gt;
   *             &lt;complexContent&gt;
   *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *                 &lt;sequence&gt;
   *                   &lt;element name="host" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
   *                   &lt;element name="ifServernameEquals" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
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
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"hostname"})
  public static class AdditionalHostnames {

    @XmlElement(namespace = "http://schema.samply.de/config/OAuth2Client")
    protected List<OAuth2Client.AdditionalHostnames.Hostname> hostname;

    /**
     * Gets the value of the hostname property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the hostname property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getHostname().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link
     * OAuth2Client.AdditionalHostnames.Hostname }
     */
    public List<OAuth2Client.AdditionalHostnames.Hostname> getHostname() {
      if (hostname == null) {
        hostname = new ArrayList<OAuth2Client.AdditionalHostnames.Hostname>();
      }
      return this.hostname;
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
     *         &lt;element name="host" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
     *         &lt;element name="ifServernameEquals" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(
        name = "",
        propOrder = {"host", "ifServernameEquals"})
    public static class Hostname {

      @XmlElement(namespace = "http://schema.samply.de/config/OAuth2Client", required = true)
      @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
      @XmlSchemaType(name = "token")
      protected String host;

      @XmlElement(namespace = "http://schema.samply.de/config/OAuth2Client", required = true)
      @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
      @XmlSchemaType(name = "token")
      protected String ifServernameEquals;

      /**
       * Gets the value of the host property.
       *
       * @return possible object is {@link String }
       */
      public String getHost() {
        return host;
      }

      /**
       * Sets the value of the host property.
       *
       * @param value allowed object is {@link String }
       */
      public void setHost(String value) {
        this.host = value;
      }

      /**
       * Gets the value of the ifServernameEquals property.
       *
       * @return possible object is {@link String }
       */
      public String getIfServernameEquals() {
        return ifServernameEquals;
      }

      /**
       * Sets the value of the ifServernameEquals property.
       *
       * @param value allowed object is {@link String }
       */
      public void setIfServernameEquals(String value) {
        this.ifServernameEquals = value;
      }
    }
  }
}
