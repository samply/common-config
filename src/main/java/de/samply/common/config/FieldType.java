package de.samply.common.config;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for fieldType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="fieldType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="string"/&gt;
 *     &lt;enumeration value="integer"/&gt;
 *     &lt;enumeration value="timestamp"/&gt;
 *     &lt;enumeration value="float"/&gt;
 *     &lt;enumeration value="json"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "fieldType", namespace = "http://schema.samply.de/config/Resources")
@XmlEnum
public enum FieldType {
  @XmlEnumValue("string")
  STRING("string"),
  @XmlEnumValue("integer")
  INTEGER("integer"),
  @XmlEnumValue("timestamp")
  TIMESTAMP("timestamp"),
  @XmlEnumValue("float")
  FLOAT("float"),
  @XmlEnumValue("json")
  JSON("json");
  private final String value;

  FieldType(String v) {
    value = v;
  }

  /** TODO: add javadoc. */
  public static FieldType fromValue(String v) {
    for (FieldType c : FieldType.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

  public String value() {
    return value;
  }
}
