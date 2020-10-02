package de.samply.common.config;

import de.samply.common.config.adapters.PathAdapter;
import java.nio.file.Path;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Java class for Keystore complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Keystore"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="File" type="{http://schema.samply.de/common}Path"/&gt;
 *         &lt;element name="Passphrase" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "Keystore",
    propOrder = {})
public class Keystore {

  @XmlElement(name = "File", required = true, type = String.class)
  @XmlJavaTypeAdapter(PathAdapter.class)
  protected Path file;

  @XmlElement(name = "Passphrase", required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String passphrase;

  /**
   * Gets the value of the file property.
   *
   * @return possible object is {@link String }
   */
  public Path getFile() {
    return file;
  }

  /**
   * Sets the value of the file property.
   *
   * @param value allowed object is {@link String }
   */
  public void setFile(Path value) {
    this.file = value;
  }

  /**
   * Gets the value of the passphrase property.
   *
   * @return possible object is {@link String }
   */
  public String getPassphrase() {
    return passphrase;
  }

  /**
   * Sets the value of the passphrase property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPassphrase(String value) {
    this.passphrase = value;
  }
}
