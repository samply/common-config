package de.samply.common.config.adapters;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Adapter for converting xml entries to {@link java.net.URL}.
 */
public class UrlAdapter extends XmlAdapter<String, URL> {

  private static final Logger logger = LoggerFactory.getLogger(UrlAdapter.class);

  /**
   * Convert a string type to a {@link java.net.URL} type.
   *
   * @param value The string to be converted. Can be null.
   * @return String
   */
  public URL unmarshal(String value) throws MalformedURLException {
    String url = value;

    if (url.split("://").length == 1) {

      String protocoll = "http";
      String[] splitUrl = url.split(":");

      try {
        if (splitUrl.length == 2 && 443 == Integer.parseInt(splitUrl[1].split("/")[0])) {
          protocoll = "https";
        }
      } catch (NumberFormatException e) {
        logger.error(e.getMessage(), e);
        throw new MalformedURLException();
      }

      url = protocoll + "://" + url;
    }

    return new URL(url.replaceAll("/$", ""));
  }

  /**
   * Convert a {@link java.net.URL} type to a string type.
   *
   * @param value The {@link java.net.URL} to be converted. Can be null.
   * @return String
   */
  public String marshal(URL value) {
    if (value == null) {
      return null;
    }
    return value.toString();
  }
}
