package edu.utec.horus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.openxava.annotations.Required;

@Entity
@Table(name = "client", comment = "Pair values used for non interactive authentication")
public class Client extends Identifiable {

  @Column(length = 50, unique = true, comment = "client id")
  @Required
  private String clientId;

  @Column(length = 50, unique = true, comment = "client secret")
  @Required
  private String clientSecret;

  @Column(length = 25, comment = "client type: GOOGLE_LOGIN, FACEBOOK_LOGIN, NON_INTERACTIVE_LOGIN")
  @Enumerated(EnumType.STRING)
  private ClientType clientType;

  @Column(length = 50, nullable = false, comment = "request origin")
  private String origin;

  @Column(length = 100, nullable = false, comment = "expected redirect")
  private String redirect;

  @Column(length = 50, nullable = false, comment = "description of this client")
  private String description;
  
  @Column(comment = "Used for disable a client without delete it")
  @Required
  private boolean enabled = false;  

  // comment=google configurations related to this client
  @OneToOne
  private GoogleOauthConfiguration googleOauthConfiguration;

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GoogleOauthConfiguration getGoogleOauthConfiguration() {
    return googleOauthConfiguration;
  }

  public void setGoogleOauthConfiguration(GoogleOauthConfiguration googleOauthConfiguration) {
    this.googleOauthConfiguration = googleOauthConfiguration;
  }

  public ClientType getClientType() {
    return clientType;
  }

  public void setClientType(ClientType clientType) {
    this.clientType = clientType;
  }

  public String getRedirect() {
    return redirect;
  }
  
  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }  

  public void setRedirect(String redirect) {
    this.redirect = redirect;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }
}
