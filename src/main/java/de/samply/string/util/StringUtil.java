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

package de.samply.string.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * A Util with static methods for simple string operations like join and isEmpty.
 *
 */
public class StringUtil {

    /**
     * Disable instantiation.
     */
    private StringUtil() {
    }

    /**
     * Joins a Collection of strings into one string, using the specified
     * delimiter and string builder.
     *
     * @param objects The list of objects that is used to construct the string.
     * @param delimiter The string delimiter
     * @param builder A builder that contructs a string from an object
     * @return The joined string
     */
    public static <T> String join(Collection<T> objects, String delimiter,
            Builder<T> builder) {
        if (objects.isEmpty()) return "";
        Iterator<T> iter = objects.iterator();
        StringBuilder buffer = new StringBuilder(builder.build(iter.next()));
        while (iter.hasNext()) buffer.append(delimiter)
                .append(builder.build(iter.next()));
        return buffer.toString();
    }

    /**
     * Joins a Collection of strings into one string, using the specified
     * delimiter.
     *
     * @param strings The list of strings that is used to construct the join.
     * @param delimiter The string delimiter
     * @return the joined strings
     */
    public static String join(Collection<String> strings, String delimiter) {
        return join(strings, delimiter, new Builder<String>() {
            @Override
            public String build(String string) {
                return string;
            }
        });
    }

    /**
     * Joins an array of objects into one string using the specified delimiter
     * and string builder.
     *
     * @param objects an array of T objects.
     * @param delimiter the delimiter
     * @param builder the builder for the objects
     * @return the joined string
     */
    public static <T> String join(T[] objects, String delimiter, Builder<T> builder) {
        return join(Arrays.asList(objects), delimiter, builder);
    }

    /**
     * Joins an array of strings into one string using the specified delimiter.
     *
     * @param strings the array of strings that will be joined
     * @param delimiter the delimiter
     * @return the joined string
     */
    public static String join(String[] strings, String delimiter) {
        return join(Arrays.asList(strings), delimiter);
    }

    /**
     * A generic builder interface that returns a string from an object.
     *
     * @param <T>
     */
    public interface Builder<T> {
        public String build(T o);
    }

    /**
     * Checks if the string is null or the trimmed content length is 0.
     *
     * @param string the input string that is checked
     * @return true if the input string is null or the trimmed content length is 0, false otherwise
     */
    public static boolean isEmpty(String string) {
        return string == null ? true : string.trim().length() == 0;
    }
}
