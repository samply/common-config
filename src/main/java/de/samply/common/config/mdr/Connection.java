package de.samply.common.config.mdr;

import de.samply.common.config.adapters.PathAdapter;
import java.nio.file.Path;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Connection {

  private Boolean useAnonymousMdrConnection;

  private Boolean useProxy;

  @XmlJavaTypeAdapter(PathAdapter.class)
  private Path pathToProxy;

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  private String urlMdr;

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  private String namespace;

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  private String authUrl;

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  private String userIdAuth;

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  private String keyId;

  @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
  private String privateKeyBase64;

  public Boolean getUseAnonymousMdrConnection() {
    return useAnonymousMdrConnection;
  }

  public void setUseAnonymousMdrConnection(Boolean useAnonymousMdrConnection) {
    this.useAnonymousMdrConnection = useAnonymousMdrConnection;
  }

  public Boolean getUseProxy() {
    return useProxy;
  }

  public void setUseProxy(Boolean useProxy) {
    this.useProxy = useProxy;
  }

  public Path getPathToProxy() {
    return pathToProxy;
  }

  public void setPathToProxy(Path pathToProxy) {
    this.pathToProxy = pathToProxy;
  }

  public String getUrlMdr() {
    return urlMdr;
  }

  public void setUrlMdr(String urlMdr) {
    this.urlMdr = urlMdr;
  }

  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public String getAuthUrl() {
    return authUrl;
  }

  public void setAuthUrl(String authUrl) {
    this.authUrl = authUrl;
  }

  public String getUserIdAuth() {
    return userIdAuth;
  }

  public void setUserIdAuth(String userIdAuth) {
    this.userIdAuth = userIdAuth;
  }

  public String getKeyId() {
    return keyId;
  }

  public void setKeyId(String keyId) {
    this.keyId = keyId;
  }

  public String getPrivateKeyBase64() {
    return privateKeyBase64;
  }

  public void setPrivateKeyBase64(String privateKeyBase64) {
    this.privateKeyBase64 = privateKeyBase64;
  }
}
