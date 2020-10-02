package de.samply.common.config.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.slf4j.event.Level;

/**
 * Adapter for converting the log level in the xml config file into {@link org.slf4j.event.Level}
 * enum.
 */
public class LogLevelAdapter extends XmlAdapter<String, Level> {

  /**
   * Convert a {@link org.slf4j.event.Level} type to a string type.
   *
   * @param value The {@link org.slf4j.event.Level} to be converted. Can be null.
   * @return String
   */
  @Override
  public String marshal(Level value) {
    if (value == null) {
      return null;
    }
    return value.toString();
  }

  /**
   * Convert a string type to a {@link org.slf4j.event.Level} type.
   *
   * @param value The string to be converted. Can be null.
   * @return String
   */
  @Override
  public Level unmarshal(String value) {
    return Level.valueOf(value);
  }
}
