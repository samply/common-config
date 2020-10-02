package de.samply.config.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 *  A util class for serialization and deserialization of XML files using JAXB.
 */
public class JaxbUtil {

  private static final Logger logger = LoggerFactory.getLogger(JaxbUtil.class);

  /** Disable instantiation. */
  private JaxbUtil() {}

  /**
   * Finds the specified file and deserializes it. Uses "samply" as prefix in the FileFinderUtil.
   *
   * @param filename the filename
   * @param clazz the class
   * @return the deserialized object
   */
  public static <T> T findUnmarshall(String filename, Class<T> clazz)
      throws FileNotFoundException, JAXBException, SAXException, ParserConfigurationException {
    return findUnmarshall(filename, clazz, "samply");
  }

  /**
   * Finds the specified file and deserializes it. Uses the given prefix for the FileFinderUtil.
   *
   * @return the deserialized object
   */
  public static <T> T findUnmarshall(String filename, Class<T> clazz, String prefix)
      throws FileNotFoundException, JAXBException, SAXException, ParserConfigurationException {
    return findUnmarshall(filename, clazz, prefix, null);
  }

  /**
   * Finds the specified file and deserializes it. Uses the given prefix and fallback for the
   * FileFinderUtil.
   *
   * @return the deserialized object
   */
  public static <T> T findUnmarshall(
      String filename, Class<T> clazz, String prefix, String... fallbacks)
      throws FileNotFoundException, JAXBException, SAXException, ParserConfigurationException {
    return findUnmarshall(filename, JAXBContext.newInstance(clazz), clazz, prefix, fallbacks);
  }

  /**
   * Finds the specified file and deserializes it. Uses "samply" as prefix in the FileFinderUtil.
   *
   * @param filename The file name
   * @param context The JAXBContext used to deserialize the XML file
   * @param clazz The class of the object that will be returned
   * @return the deserialized object
   * @throws java.io.FileNotFoundException if the file can not be found
   * @throws javax.xml.bind.JAXBException if the XMl can not be deserialized
   * @throws org.xml.sax.SAXException if the file does not contain valid XML
   * @throws javax.xml.parsers.ParserConfigurationException if the configuration of the XML parser
   *     is not valid (should never happen)
   */
  public static <T> T findUnmarshall(String filename, JAXBContext context, Class<T> clazz)
      throws FileNotFoundException, JAXBException, SAXException, ParserConfigurationException {
    return findUnmarshall(filename, context, clazz, "samply");
  }

  /**
   * Finds the specified file and deserializes it. Uses the given prefix and no fallback folder
   *
   * @param filename The file name
   * @param context The JAXBContext used to deserialize the XML file
   * @param clazz The class of the object that will be returned
   * @param prefix The prefix
   * @return the deserialized object
   * @throws java.io.FileNotFoundException if the file can not be found
   * @throws javax.xml.bind.JAXBException if the XMl can not be deserialized
   * @throws org.xml.sax.SAXException if the file does not contain valid XML
   * @throws javax.xml.parsers.ParserConfigurationException if the configuration of the XML parser
   *     is not valid (should never happen)
   */
  public static <T> T findUnmarshall(
      String filename, JAXBContext context, Class<T> clazz, String prefix)
      throws FileNotFoundException, JAXBException, SAXException, ParserConfigurationException {
    return findUnmarshall(filename, context, clazz, prefix, null);
  }

  /**
   * Finds the specified file and deserializes it.
   *
   * @param filename The file name
   * @param context The JAXBContext used to deserialize the XML file
   * @param clazz The class of the object that will be returned
   * @param prefix The prefix used in the FileFinderUtil
   * @param fallbackRoots The path to the fallback folder
   * @return the deserialized object
   * @throws java.io.FileNotFoundException if the file can not be found
   * @throws javax.xml.bind.JAXBException if the XMl can not be deserialized
   * @throws org.xml.sax.SAXException if the file does not contain valid XML
   * @throws javax.xml.parsers.ParserConfigurationException if the configuration of the XML parser
   *     is not valid (should never happen)
   */
  public static <T> T findUnmarshall(
      String filename, JAXBContext context, Class<T> clazz, String prefix, String... fallbackRoots)
      throws FileNotFoundException, JAXBException, SAXException, ParserConfigurationException {
    try {
      return unmarshall(FileFinderUtil.findFile(filename, prefix, fallbackRoots), context, clazz);
    } catch (FileNotFoundException e) {
      logger.info("File still not found, trying to use the class loader.");
      InputStream stream =
          JaxbUtil.class.getClassLoader().getResourceAsStream(prefix + File.separator + filename);

      /** If prefix/filename does not exist, try just filename without the prefix. */
      if (stream == null) {
        stream = JaxbUtil.class.getClassLoader().getResourceAsStream(filename);
      }

      if (stream != null) {
        logger.info("Resource {} found as stream using the class loader.", filename);
        return unmarshall(stream, context, clazz);
      } else {
        throw new FileNotFoundException(filename);
      }
    }
  }

  /**
   * Deserializes the specified file using the specified context. Is aware of namespces and
   * xinclude.
   *
   * @param file The file name
   * @param context a {@link javax.xml.bind.JAXBContext} object.
   * @param clazz a {@link java.lang.Class} object.
   * @return the deserialized object
   * @throws javax.xml.bind.JAXBException if any.
   * @throws org.xml.sax.SAXException if any.
   * @throws javax.xml.parsers.ParserConfigurationException if any.
   */
  @SuppressWarnings("unchecked")
  public static <T> T unmarshall(File file, JAXBContext context, Class<T> clazz)
      throws JAXBException, SAXException, ParserConfigurationException, FileNotFoundException {
    return unmarshall(new FileInputStream(file), context, clazz);
  }

  /**
   * Unmarshalls the given stream using the given jaxb context into the given class.
   *
   * @return the deserialized object
   */
  @SuppressWarnings("unchecked")
  public static <T> T unmarshall(InputStream stream, JAXBContext context, Class<T> clazz)
      throws ParserConfigurationException, SAXException, JAXBException {
    SAXParserFactory spf = SAXParserFactory.newInstance();

    spf.setXIncludeAware(true);
    spf.setNamespaceAware(true);
    spf.setValidating(false);

    XMLReader xr = spf.newSAXParser().getXMLReader();

    SAXSource source = new SAXSource(xr, new InputSource(stream));

    Object obj = context.createUnmarshaller().unmarshal(source);

    if (obj instanceof JAXBElement<?>) {
      return (T) ((JAXBElement<?>) obj).getValue();
    } else {
      return (T) obj;
    }
  }

  /**
   * Serializes the specified object into XML, using the specified JAXBContext.
   *
   * @param object a T object.
   * @param context a {@link javax.xml.bind.JAXBContext} object.
   * @param <T> a T object.
   * @return the serialized representation
   * @throws javax.xml.bind.JAXBException if any.
   */
  public static <T> String marshall(T object, JAXBContext context) throws JAXBException {
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    StringWriter writer = new StringWriter();

    marshaller.marshal(object, writer);
    return writer.toString();
  }
}
