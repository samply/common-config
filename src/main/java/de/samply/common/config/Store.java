package de.samply.common.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{http://schema.samply.de/common}postgresql"/&gt;
 *         &lt;element name="security"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="hashAlgorithm" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *                   &lt;element name="rounds" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *                   &lt;element name="postfix" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *                   &lt;element name="maxFailCounter" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    propOrder = {"postgresql", "security"})
@XmlRootElement(name = "store", namespace = "http://schema.samply.de/config/Store")
public class Store {

  @XmlElement protected Postgresql postgresql;

  @XmlElement(namespace = "http://schema.samply.de/config/Store", required = true)
  protected Store.Security security;

  /**
   * Gets the value of the postgresql property.
   *
   * @return possible object is {@link Postgresql }
   */
  public Postgresql getPostgresql() {
    return postgresql;
  }

  /**
   * Sets the value of the postgresql property.
   *
   * @param value allowed object is {@link Postgresql }
   */
  public void setPostgresql(Postgresql value) {
    this.postgresql = value;
  }

  /**
   * Gets the value of the security property.
   *
   * @return possible object is {@link Store.Security }
   */
  public Store.Security getSecurity() {
    return security;
  }

  /**
   * Sets the value of the security property.
   *
   * @param value allowed object is {@link Store.Security }
   */
  public void setSecurity(Store.Security value) {
    this.security = value;
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
   *         &lt;element name="hashAlgorithm" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
   *         &lt;element name="rounds" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
   *         &lt;element name="postfix" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
   *         &lt;element name="maxFailCounter" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"hashAlgorithm", "rounds", "postfix", "maxFailCounter"})
  public static class Security {

    @XmlElement(namespace = "http://schema.samply.de/config/Store", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    String hashAlgorithm;

    @XmlElement(namespace = "http://schema.samply.de/config/Store")
    int rounds;

    @XmlElement(namespace = "http://schema.samply.de/config/Store", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    String postfix;

    @XmlElement(namespace = "http://schema.samply.de/config/Store")
    int maxFailCounter;

    /**
     * Gets the value of the hashAlgorithm property.
     *
     * @return possible object is {@link String }
     */
    public String getHashAlgorithm() {
      return hashAlgorithm;
    }

    /**
     * Sets the value of the hashAlgorithm property.
     *
     * @param value allowed object is {@link String }
     */
    public void setHashAlgorithm(String value) {
      this.hashAlgorithm = value;
    }

    /** Gets the value of the rounds property. */
    public int getRounds() {
      return rounds;
    }

    /** Sets the value of the rounds property. */
    public void setRounds(int value) {
      this.rounds = value;
    }

    /**
     * Gets the value of the postfix property.
     *
     * @return possible object is {@link String }
     */
    public String getPostfix() {
      return postfix;
    }

    /**
     * Sets the value of the postfix property.
     *
     * @param value allowed object is {@link String }
     */
    public void setPostfix(String value) {
      this.postfix = value;
    }

    /** Gets the value of the maxFailCounter property. */
    public int getMaxFailCounter() {
      return maxFailCounter;
    }

    /** Sets the value of the maxFailCounter property. */
    public void setMaxFailCounter(int value) {
      this.maxFailCounter = value;
    }
  }
}
