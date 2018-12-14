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

import org.slf4j.event.Level;

import javax.xml.bind.annotation.adapters.XmlAdapter;


/**
 * Adapter for converting the log level in the xml config file into
 * {@link org.slf4j.event.Level} enum.
 * 
 *
 */
public class LogLevelAdapter extends XmlAdapter<String, Level> {

    /**
	 * Convert a {@link org.slf4j.event.Level} type to a string type.
	 * 
	 * @param value
	 *            The {@link org.slf4j.event.Level} to be converted.
	 *            Can be null.
	 * 
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
	 * @param value
	 *            The string to be converted. Can be null.
	 * 
	 * @return String
	 */
    @Override
    public Level unmarshal(String value) {
        return Level.valueOf(value);
    }

}
