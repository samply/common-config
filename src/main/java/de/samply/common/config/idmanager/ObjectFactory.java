package de.samply.common.config.idmanager;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the de.samply.common.config.idmanager package.
 *
 * <p>An ObjectFactory allows you to programatically construct new instances of the Java
 * representation for XML content. The Java representation of XML content can consist of schema
 * derived interfaces and classes representing the binding of schema type definitions, element
 * declarations and model groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

  private static final QName _Mainzelliste_QNAME =
      new QName("http://schema.samply.de/id-manager", "Mainzelliste");
  private static final QName _SplitDate_QNAME =
      new QName("http://schema.samply.de/id-manager", "SplitDate");
  private static final QName _IdManager_QNAME =
      new QName("http://schema.samply.de/id-manager", "ID-Manager");

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes
   * for package: de.samply.common.config.idmanager.
   */
  public ObjectFactory() {}

  /**
   * Create an instance of {@link Server }.
   */
  public Server createServer() {
    return new Server();
  }

  /**
   * Create an instance of {@link IdManager }.
   */
  public IdManager createIdManager() {
    return new IdManager();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link IdManager }{@code >}}.
   */
  @XmlElementDecl(namespace = "http://schema.samply.de/id-manager", name = "ID-Manager")
  public JAXBElement<IdManager> createIdManager(IdManager value) {
    return new JAXBElement<IdManager>(_IdManager_QNAME, IdManager.class, null, value);
  }

  /**
   * Create an instance of {@link SplitDate }.
   */
  public SplitDate createSplitDate() {
    return new SplitDate();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SplitDate }{@code >}}.
   */
  @XmlElementDecl(namespace = "http://schema.samply.de/id-manager", name = "SplitDate")
  public JAXBElement<SplitDate> createSplitDate(SplitDate value) {
    return new JAXBElement<SplitDate>(_SplitDate_QNAME, SplitDate.class, null, value);
  }

  /**
   * Create an instance of {@link Mainzelliste }.
   */
  public Mainzelliste createMainzelliste() {
    return new Mainzelliste();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link Mainzelliste }{@code >}}.
   */
  @XmlElementDecl(namespace = "http://schema.samply.de/id-manager", name = "Mainzelliste")
  public JAXBElement<Mainzelliste> createMainzelliste(Mainzelliste value) {
    return new JAXBElement<Mainzelliste>(_Mainzelliste_QNAME, Mainzelliste.class, null, value);
  }

  /**
   * Create an instance of {@link ControlNumberGenerator }.
   */
  public ControlNumberGenerator createControlNumberGenerator() {
    return new ControlNumberGenerator();
  }

  /**
   * Create an instance of {@link Server.Permissions }.
   */
  public Server.Permissions createServerPermissions() {
    return new Server.Permissions();
  }

  /**
   * Create an instance of {@link Server.AllowedRemoteAdresses }.
   */
  public Server.AllowedRemoteAdresses createServerAllowedRemoteAdresses() {
    return new Server.AllowedRemoteAdresses();
  }

  /**
   * Create an instance of {@link IdManager.Servers }.
   */
  public IdManager.Servers createIdManagerServers() {
    return new IdManager.Servers();
  }

  /**
   * Create an instance of {@link IdManager.ControlNumberGenerators }.
   */
  public IdManager.ControlNumberGenerators createIdManagerControlNumberGenerators() {
    return new IdManager.ControlNumberGenerators();
  }

  /**
   * Create an instance of {@link IdManager.SplitDates }.
   */
  public IdManager.SplitDates createIdManagerSplitDates() {
    return new IdManager.SplitDates();
  }

  /**
   * Create an instance of {@link SplitDate.Output }.
   */
  public SplitDate.Output createSplitDateOutput() {
    return new SplitDate.Output();
  }
}
