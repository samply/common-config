package de.samply.common.config;

import de.samply.common.config.adapters.LogLevelAdapter;
import de.samply.common.config.adapters.PathAdapter;
import java.math.BigInteger;
import java.nio.file.Path;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.slf4j.event.Level;


/**
 * Java class for Log complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Log"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="File" type="{http://schema.samply.de/common}Path" minOccurs="0"/&gt;
 *         &lt;element name="Level" type="{http://schema.samply.de/common}Level" minOccurs="0"/&gt;
 *         &lt;element name="MaxAge" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "Log",
    propOrder = {})
public class Log {

  @XmlElement(name = "File", type = String.class)
  @XmlJavaTypeAdapter(PathAdapter.class)
  protected Path file;

  @XmlElement(name = "Level", type = String.class)
  @XmlJavaTypeAdapter(LogLevelAdapter.class)
  protected Level level;

  @XmlElement(name = "MaxAge")
  @XmlSchemaType(name = "nonNegativeInteger")
  protected BigInteger maxAge;

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
   * Gets the value of the level property.
   *
   * @return possible object is {@link String }
   */
  public Level getLevel() {
    return level;
  }

  /**
   * Sets the value of the level property.
   *
   * @param value allowed object is {@link String }
   */
  public void setLevel(Level value) {
    this.level = value;
  }

  /**
   * Gets the value of the maxAge property.
   *
   * @return possible object is {@link BigInteger }
   */
  public BigInteger getMaxAge() {
    return maxAge;
  }

  /**
   * Sets the value of the maxAge property.
   *
   * @param value allowed object is {@link BigInteger }
   */
  public void setMaxAge(BigInteger value) {
    this.maxAge = value;
  }
}
