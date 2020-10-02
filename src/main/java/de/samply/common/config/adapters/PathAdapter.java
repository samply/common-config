package de.samply.common.config.adapters;

import java.nio.file.Path;
import java.nio.file.Paths;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter for converting strings in xml files into {@link java.nio.file.Path} objects.
 */
public class PathAdapter extends XmlAdapter<String, Path> {

  /**
   * Convert a path type to a string type.
   *
   * @param value The path to be converted. Can be null.
   * @return String
   */
  @Override
  public String marshal(Path value) {
    if (value == null) {
      return null;
    }
    return value.toString();
  }

  /**
   * Convert a string type to a path type.
   *
   * @param value The string to be converted. Can be null.
   * @return Path
   */
  @Override
  public Path unmarshal(String value) {
    if (value != null) {
      return Paths.get(value.trim());
    }

    return null;
  }
}
