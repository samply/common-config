package de.samply.common.config.idmanager;

import de.samply.common.config.Log;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Java class for ID-Manager complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ID-Manager"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Dist" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="InstanceID" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="Debug" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="Log" type="{http://schema.samply.de/common}Log" minOccurs="0"/&gt;
 *         &lt;element name="Servers" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Server" type="{http://schema.samply.de/id-manager}Server" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ControlNumberGenerators" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ControlNumberGenerator" type="{http://schema.samply.de/id-manager}ControlNumberGenerator" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Mainzelliste" type="{http://schema.samply.de/id-manager}Mainzelliste"/&gt;
 *         &lt;element name="SplitDates"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="SplitDate" type="{http://schema.samply.de/id-manager}SplitDate" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "ID-Manager",
    propOrder = {
      "dist",
      "instanceID",
      "debug",
      "log",
      "servers",
      "controlNumberGenerators",
      "mainzelliste",
      "splitDates"
    })
public class IdManager {

  @XmlElement(
      name = "Dist",
      required = true,
      defaultValue = "Lokales Identitätsmanagement der CCP-IT")
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String dist;

  @XmlElement(name = "InstanceID", required = true)
  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  @XmlSchemaType(name = "token")
  protected String instanceID;

  @XmlElement(name = "Debug")
  protected Boolean debug;

  @XmlElement(name = "Log")
  protected Log log;

  @XmlElement(name = "Servers")
  protected IdManager.Servers servers;

  @XmlElement(name = "ControlNumberGenerators")
  protected IdManager.ControlNumberGenerators controlNumberGenerators;

  @XmlElement(name = "Mainzelliste", required = true)
  protected Mainzelliste mainzelliste;

  @XmlElement(name = "SplitDates", required = true)
  protected IdManager.SplitDates splitDates;

  /**
   * Gets the value of the dist property.
   *
   * @return possible object is {@link String }
   */
  public String getDist() {
    return dist;
  }

  /**
   * Sets the value of the dist property.
   *
   * @param value allowed object is {@link String }
   */
  public void setDist(String value) {
    this.dist = value;
  }

  /**
   * Gets the value of the instanceID property.
   *
   * @return possible object is {@link String }
   */
  public String getInstanceID() {
    return instanceID;
  }

  /**
   * Sets the value of the instanceID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setInstanceID(String value) {
    this.instanceID = value;
  }

  /**
   * Gets the value of the debug property.
   *
   * @return possible object is {@link Boolean }
   */
  public Boolean isDebug() {
    return debug;
  }

  /**
   * Sets the value of the debug property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setDebug(Boolean value) {
    this.debug = value;
  }

  /**
   * Gets the value of the log property.
   *
   * @return possible object is {@link Log }
   */
  public Log getLog() {
    return log;
  }

  /**
   * Sets the value of the log property.
   *
   * @param value allowed object is {@link Log }
   */
  public void setLog(Log value) {
    this.log = value;
  }

  /**
   * Gets the value of the servers property.
   *
   * @return possible object is {@link IdManager.Servers }
   */
  public IdManager.Servers getServers() {
    return servers;
  }

  /**
   * Sets the value of the servers property.
   *
   * @param value allowed object is {@link IdManager.Servers }
   */
  public void setServers(IdManager.Servers value) {
    this.servers = value;
  }

  /**
   * Gets the value of the controlNumberGenerators property.
   *
   * @return possible object is {@link IdManager.ControlNumberGenerators }
   */
  public IdManager.ControlNumberGenerators getControlNumberGenerators() {
    return controlNumberGenerators;
  }

  /**
   * Sets the value of the controlNumberGenerators property.
   *
   * @param value allowed object is {@link IdManager.ControlNumberGenerators }
   */
  public void setControlNumberGenerators(IdManager.ControlNumberGenerators value) {
    this.controlNumberGenerators = value;
  }

  /**
   * Gets the value of the mainzelliste property.
   *
   * @return possible object is {@link Mainzelliste }
   */
  public Mainzelliste getMainzelliste() {
    return mainzelliste;
  }

  /**
   * Sets the value of the mainzelliste property.
   *
   * @param value allowed object is {@link Mainzelliste }
   */
  public void setMainzelliste(Mainzelliste value) {
    this.mainzelliste = value;
  }

  /**
   * Gets the value of the splitDates property.
   *
   * @return possible object is {@link IdManager.SplitDates }
   */
  public IdManager.SplitDates getSplitDates() {
    return splitDates;
  }

  /**
   * Sets the value of the splitDates property.
   *
   * @param value allowed object is {@link IdManager.SplitDates }
   */
  public void setSplitDates(IdManager.SplitDates value) {
    this.splitDates = value;
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="ControlNumberGenerator" type="{http://schema.samply.de/id-manager}ControlNumberGenerator" maxOccurs="unbounded" minOccurs="0"/&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"controlNumberGenerators"})
  public static class ControlNumberGenerators {

    @XmlElement(name = "ControlNumberGenerator")
    protected List<ControlNumberGenerator> controlNumberGenerators;

    /**
     * Gets the value of the controlNumberGenerators property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the controlNumberGenerators property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getControlNumberGenerators().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link ControlNumberGenerator }
     */
    public List<ControlNumberGenerator> getControlNumberGenerators() {
      if (controlNumberGenerators == null) {
        controlNumberGenerators = new ArrayList<ControlNumberGenerator>();
      }
      return this.controlNumberGenerators;
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="Server" type="{http://schema.samply.de/id-manager}Server" maxOccurs="unbounded" minOccurs="0"/&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"servers"})
  public static class Servers {

    @XmlElement(name = "Server")
    protected List<Server> servers;

    /**
     * Gets the value of the servers property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the servers property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getServers().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link Server }
     */
    public List<Server> getServers() {
      if (servers == null) {
        servers = new ArrayList<Server>();
      }
      return this.servers;
    }
  }

  /**
   * Java class for anonymous complex type.
   *
   * <p>The following schema fragment specifies the expected content contained within this class.
   *
   * <pre>
   * &lt;complexType&gt;
   *   &lt;complexContent&gt;
   *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
   *       &lt;sequence&gt;
   *         &lt;element name="SplitDate" type="{http://schema.samply.de/id-manager}SplitDate" maxOccurs="unbounded" minOccurs="0"/&gt;
   *       &lt;/sequence&gt;
   *     &lt;/restriction&gt;
   *   &lt;/complexContent&gt;
   * &lt;/complexType&gt;
   * </pre>
   */
  @XmlAccessorType(XmlAccessType.FIELD)
  @XmlType(
      name = "",
      propOrder = {"splitDates"})
  public static class SplitDates {

    @XmlElement(name = "SplitDate")
    protected List<SplitDate> splitDates;

    /**
     * Gets the value of the splitDates property.
     *
     * <p>This accessor method returns a reference to the live list, not a snapshot. Therefore any
     * modification you make to the returned list will be present inside the JAXB object. This is
     * why there is not a <CODE>set</CODE> method for the splitDates property.
     *
     * <p>For example, to add a new item, do as follows:
     *
     * <pre>
     *    getSplitDates().add(newItem);
     * </pre>
     *
     * <p>Objects of the following type(s) are allowed in the list {@link SplitDate }
     */
    public List<SplitDate> getSplitDates() {
      if (splitDates == null) {
        splitDates = new ArrayList<SplitDate>();
      }
      return this.splitDates;
    }
  }
}
