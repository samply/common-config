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

package de.samply.config.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import java.io.*;

/**
 * A util class for serialization and deserialization of XML files using JAXB.
 *
 */
public class JAXBUtil {

    private static final Logger logger = LoggerFactory.getLogger(JAXBUtil.class);

    /**
     * Disable instantiation.
     */
    private JAXBUtil() {
    }

    /**
     * Finds the specified file and deserializes it. Uses "samply"
     * as prefix in the FileFinderUtil.
     *
     * @param filename the filename
     * @param clazz the class
     * @return
     * @throws FileNotFoundException
     * @throws JAXBException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public static <T> T findUnmarshall(String filename, Class<T> clazz) throws FileNotFoundException, JAXBException, SAXException,
            ParserConfigurationException {
        return findUnmarshall(filename, clazz, "samply");
    }

    /**
     * Finds the specified file and deserializes it. Uses the given prefix for the FileFinderUtil.
     *
     * @param filename
     * @param clazz
     * @param prefix
     * @return
     * @throws FileNotFoundException
     * @throws JAXBException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public static <T> T findUnmarshall(String filename, Class<T> clazz, String prefix) throws FileNotFoundException, JAXBException,
            SAXException, ParserConfigurationException {
        return findUnmarshall(filename, clazz, prefix, null);
    }

    /**
     * Finds the specified file and deserializes it. Uses the given prefix and fallback for the FileFinderUtil.
     *
     * @param filename
     * @param clazz
     * @param prefix
     * @param fallback
     * @return
     * @throws FileNotFoundException
     * @throws JAXBException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public static <T> T findUnmarshall(String filename, Class<T> clazz, String prefix, String fallback) throws FileNotFoundException, JAXBException,
            SAXException, ParserConfigurationException {
        return findUnmarshall(filename, JAXBContext.newInstance(clazz), clazz, prefix, fallback);
    }

    /**
     * Finds the specified file and deserializes it. Uses "samply"
     * as prefix in the FileFinderUtil.
     *
     * @param filename The file name
     * @param context The JAXBContext used to deserialize the XML file
     * @param clazz The class of the object that will be returned
     * @throws java.io.FileNotFoundException if the file can not be found
     * @throws javax.xml.bind.JAXBException if the XMl can not be deserialized
     * @throws org.xml.sax.SAXException if the file does not contain valid XML
     * @throws javax.xml.parsers.ParserConfigurationException if the configuration of the XML parser is not valid (should never happen)
     * @return the deserialized object
     */
    public static <T> T findUnmarshall(String filename, JAXBContext context, Class<T> clazz) throws FileNotFoundException,
            JAXBException, SAXException, ParserConfigurationException {
        return findUnmarshall(filename, context, clazz, "samply");
    }

    /**
     * Finds the specified file and deserializes it. Uses the given prefix and no fallback folder
     *
     * @param filename The file name
     * @param context The JAXBContext used to deserialize the XML file
     * @param clazz The class of the object that will be returned
     * @param prefix The prefix
     * @throws java.io.FileNotFoundException if the file can not be found
     * @throws javax.xml.bind.JAXBException if the XMl can not be deserialized
     * @throws org.xml.sax.SAXException if the file does not contain valid XML
     * @throws javax.xml.parsers.ParserConfigurationException if the configuration of the XML parser is not valid (should never happen)
     * @return the deserialized object
     */
    public static <T> T findUnmarshall(String filename, JAXBContext context, Class<T> clazz, String prefix) throws FileNotFoundException,
            JAXBException, SAXException, ParserConfigurationException {
        return findUnmarshall(filename, context, clazz, prefix, null);
    }

    /**
     * Finds the specified file and deserializes it.
     *
     * @param filename The file name
     * @param context The JAXBContext used to deserialize the XML file
     * @param clazz The class of the object that will be returned
     * @param prefix The prefix used in the FileFinderUtil
     * @param fallbackRoot The path to the fallback folder
     * @throws java.io.FileNotFoundException if the file can not be found
     * @throws javax.xml.bind.JAXBException if the XMl can not be deserialized
     * @throws org.xml.sax.SAXException if the file does not contain valid XML
     * @throws javax.xml.parsers.ParserConfigurationException if the configuration of the XML parser is not valid (should never happen)
     * @return the deserialized object
     */
    public static <T> T findUnmarshall(String filename, JAXBContext context, Class<T> clazz, String prefix, String fallbackRoot) throws FileNotFoundException,
        JAXBException, SAXException, ParserConfigurationException {
        try {
            return unmarshall(FileFinderUtil.findFile(filename, prefix, fallbackRoot), context, clazz);
        } catch(FileNotFoundException e) {
            logger.info("File still not found, trying to use the class loader.");
            InputStream stream = JAXBUtil.class.getClassLoader().getResourceAsStream(prefix + File.separator + filename);

            /**
             * If prefix/filename does not exist, try just filename without the prefix.
             */
            if(stream == null) {
                stream = JAXBUtil.class.getClassLoader().getResourceAsStream(filename);
            }

            if(stream != null) {
                logger.info("Resource {} found as stream using the class loader.", filename);
                return unmarshall(stream, context, clazz);
            } else {
                throw new FileNotFoundException(filename);
            }
        }
    }

    /**
     * Deserializes the specified file using the specified context. Is aware of namespces and xinclude.
     *
     * @param file The file name
     * @param context a {@link javax.xml.bind.JAXBContext} object.
     * @param clazz a {@link java.lang.Class} object.
     * @throws javax.xml.bind.JAXBException if any.
     * @throws org.xml.sax.SAXException if any.
     * @throws javax.xml.parsers.ParserConfigurationException if any.
     * @return the deserialized object
     */
    @SuppressWarnings("unchecked")
    public static <T> T unmarshall(File file, JAXBContext context, Class<T> clazz) throws JAXBException, SAXException,
            ParserConfigurationException, FileNotFoundException {
        return unmarshall(new FileInputStream(file), context, clazz);
    }

    /**
     * Unmarshalls the given stream using the given jaxb context into the given class.
     * @param stream
     * @param context
     * @param clazz
     * @param <T>
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T unmarshall(InputStream stream, JAXBContext context, Class<T> clazz) throws ParserConfigurationException, SAXException, JAXBException {
        SAXParserFactory spf = SAXParserFactory.newInstance();

        spf.setXIncludeAware(true);
        spf.setNamespaceAware(true);
        spf.setValidating(false);

        XMLReader xr = spf.newSAXParser().getXMLReader();

        SAXSource source = new SAXSource(xr, new InputSource(stream));

        Object obj = context.createUnmarshaller().unmarshal(source);

        if(obj instanceof JAXBElement<?>) {
            return (T) ((JAXBElement<?>) obj).getValue();
        } else {
            return (T) obj;
        }
    }

    /**
     * Serializes the specified object into XML, using the specified JAXBContext.
     *
     * @param object a T object.
     * @throws javax.xml.bind.JAXBException if any.
     * @param context a {@link javax.xml.bind.JAXBContext} object.
     * @param <T> a T object.
     * @return the serialized representation
     */
    public static <T> String marshall(T object, JAXBContext context) throws JAXBException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );

        StringWriter writer = new StringWriter();

        marshaller.marshal(object,  writer);
        return writer.toString();
    }

}
