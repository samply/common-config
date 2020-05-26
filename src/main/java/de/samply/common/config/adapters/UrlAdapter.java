/*
 * Copyright (C) 2015 Working Group on Joint Research, University Medical Center Mainz
 * Copyright (C) since 2016 The Samply Community
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Affero General Public License as published by the Free
 * Software Foundation; either version 3 of the License, or (at your option) any
 * later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 *
 * Additional permission under GNU GPL version 3 section 7:
 *
 * If you modify this Program, or any covered work, by linking or combining it
 * with Jersey (https://jersey.java.net) (or a modified version of that
 * library), containing parts covered by the terms of the General Public
 * License, version 2.0, the licensors of this Program grant you additional
 * permission to convey the resulting work.
 */

package de.samply.common.config.adapters;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Adapter for converting xml entries to {@link java.net.URL}.
 */
public class UrlAdapter extends XmlAdapter<String, URL> {

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
