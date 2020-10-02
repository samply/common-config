package de.samply.common.config;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the de.samply.common.config package.
 *
 * <p>An ObjectFactory allows you to programatically construct new instances of the Java
 * representation for XML content. The Java representation of XML content can consist of schema
 * derived interfaces and classes representing the binding of schema type definitions, element
 * declarations and model groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

  private static final QName _OAuth2Provider_QNAME =
      new QName("http://schema.samply.de/config/OAuth2Provider", "oAuth2Provider");
  private static final QName _Postgresql_QNAME =
      new QName("http://schema.samply.de/common", "postgresql");
  private static final QName _Configuration_QNAME =
      new QName("http://schema.samply.de/common", "Configuration");
  private static final QName _OAuth2Client_QNAME =
      new QName("http://schema.samply.de/config/OAuth2Client", "oAuth2Client");

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes
   * for package: de.samply.common.config
   */
  public ObjectFactory() {}

  /** 
   * Create an instance of {@link Store }.
   */
  public Store createStore() {
    return new Store();
  }

  /**
   * Create an instance of {@link Resources }.
   */
  public Resources createResources() {
    return new Resources();
  }

  /**
   * Create an instance of {@link OAuth2Client }.
   */
  public OAuth2Client createOAuth2Client() {
    return new OAuth2Client();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OAuth2Client }{@code >}}.
   */
  @XmlElementDecl(namespace = "http://schema.samply.de/config/OAuth2Client", name = "oAuth2Client")
  public JAXBElement<OAuth2Client> createOAuth2Client(OAuth2Client value) {
    return new JAXBElement<OAuth2Client>(_OAuth2Client_QNAME, OAuth2Client.class, null, value);
  }

  /**
   * Create an instance of {@link OAuth2Client.AdditionalHostnames }.
   */
  public OAuth2Client.AdditionalHostnames createOAuth2ClientAdditionalHostnames() {
    return new OAuth2Client.AdditionalHostnames();
  }

  /**
   * Create an instance of {@link Resources.ResourceType }.
   */
  public Resources.ResourceType createResourcesResourceType() {
    return new Resources.ResourceType();
  }

  /**
   * Create an instance of {@link Proxy }.
   */
  public Proxy createProxy() {
    return new Proxy();
  }

  /**
   * Create an instance of {@link OAuth2Provider }.
   */
  public OAuth2Provider createOAuth2Provider() {
    return new OAuth2Provider();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link OAuth2Provider }{@code >}}. 
   */
  @XmlElementDecl(
      namespace = "http://schema.samply.de/config/OAuth2Provider",
      name = "oAuth2Provider")
  public JAXBElement<OAuth2Provider> createOAuth2Provider(OAuth2Provider value) {
    return new JAXBElement<OAuth2Provider>(
        _OAuth2Provider_QNAME, OAuth2Provider.class, null, value);
  }

  /**
   * Create an instance of {@link Postgresql }. 
   */
  public Postgresql createPostgresql() {
    return new Postgresql();
  }

  /**
   *  Create an instance of {@link JAXBElement }{@code <}{@link Postgresql }{@code >}}. 
   *  */
  @XmlElementDecl(namespace = "http://schema.samply.de/common", name = "postgresql")
  public JAXBElement<Postgresql> createPostgresql(Postgresql value) {
    return new JAXBElement<Postgresql>(_Postgresql_QNAME, Postgresql.class, null, value);
  }

  /** 
   * Create an instance of {@link Configuration }. 
   */
  public Configuration createConfiguration() {
    return new Configuration();
  }

  /** 
   * Create an instance of {@link JAXBElement }{@code <}{@link Configuration }{@code >}}.
   */
  @XmlElementDecl(namespace = "http://schema.samply.de/common", name = "Configuration")
  public JAXBElement<Configuration> createConfiguration(Configuration value) {
    return new JAXBElement<Configuration>(_Configuration_QNAME, Configuration.class, null, value);
  }

  /** 
   * Create an instance of {@link Log }. 
   */
  public Log createLog() {
    return new Log();
  }

  /** 
   * Create an instance of {@link Keystore }.
   */
  public Keystore createKeystore() {
    return new Keystore();
  }

  /** 
   * Create an instance of {@link HostAuth }.
   */
  public HostAuth createHostAuth() {
    return new HostAuth();
  }

  /** 
   * Create an instance of {@link Store.Security }.
   */
  public Store.Security createStoreSecurity() {
    return new Store.Security();
  }

  /** 
   * Create an instance of {@link OAuth2Client.AdditionalHostnames.Hostname }.
   */
  public OAuth2Client.AdditionalHostnames.Hostname createOAuth2ClientAdditionalHostnamesHostname() {
    return new OAuth2Client.AdditionalHostnames.Hostname();
  }

  /** 
   * Create an instance of {@link Resources.ResourceType.Field }.
   */
  public Resources.ResourceType.Field createResourcesResourceTypeField() {
    return new Resources.ResourceType.Field();
  }

  /**
   * Create an instance of {@link Resources.ResourceType.Relation }.
   */
  public Resources.ResourceType.Relation createResourcesResourceTypeRelation() {
    return new Resources.ResourceType.Relation();
  }

  /** 
   * Create an instance of {@link Proxy.NoProxyHosts }.
   */
  public Proxy.NoProxyHosts createProxyNoProxyHosts() {
    return new Proxy.NoProxyHosts();
  }
}
