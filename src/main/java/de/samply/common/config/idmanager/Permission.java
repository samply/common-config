package de.samply.common.config.idmanager;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * Java class for Permission.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="Permission"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="getIds"/&gt;
 *     &lt;enumeration value="getIdToken"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "Permission")
@XmlEnum
public enum Permission {
  @XmlEnumValue("getIds")
  GET_IDS("getIds"),
  @XmlEnumValue("getIdToken")
  GET_ID_TOKEN("getIdToken");
  private final String value;

  Permission(String v) {
    value = v;
  }

  /** TODO: add javadoc. */
  public static Permission fromValue(String v) {
    for (Permission c : Permission.values()) {
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
