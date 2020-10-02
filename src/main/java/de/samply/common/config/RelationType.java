package de.samply.common.config;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for relationType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="relationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="n_to_1"/&gt;
 *     &lt;enumeration value="n_to_m"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "relationType", namespace = "http://schema.samply.de/config/Resources")
@XmlEnum
public enum RelationType {
  @XmlEnumValue("n_to_1")
  N_TO_1("n_to_1"),
  @XmlEnumValue("n_to_m")
  N_TO_M("n_to_m");
  private final String value;

  RelationType(String v) {
    value = v;
  }

  /** TODO: add javadoc. */
  public static RelationType fromValue(String v) {
    for (RelationType c : RelationType.values()) {
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
