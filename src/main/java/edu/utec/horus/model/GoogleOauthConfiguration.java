package edu.utec.horus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.openxava.annotations.Required;

@Entity
@Table(name = "google_oauth_configuration",
    comment = "Values from web client oauth2 in console.developers.google.com")
public class GoogleOauthConfiguration extends Identifiable {

  @Column(length = 100, comment = "client id from console.developers.google.com")
  @Required
  private String clientId;

  @Column(length = 100, comment = "client secret from console.developers.google.com")
  private String clientSecret;

  @Column(length = 100, comment = "origin from console.developers.google.com")
  private String origin;

  @Column(length = 150, comment = "redirect from console.developers.google.com")
  private String redirect;

  @Column(length = 200, comment = "scopes from console.developers.google.com")
  private String scopes;

  @Column(length = 100, comment = "additional comments")
  private String comments;

  @Column(length = 150, comment = "custom field to store several field in json format.")
  private String custom;

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

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getRedirect() {
    return redirect;
  }

  public void setRedirect(String redirect) {
    this.redirect = redirect;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public String getScopes() {
    return scopes;
  }

  public void setScopes(String scopes) {
    this.scopes = scopes;
  }

  public String getCustom() {
    return custom;
  }

  public void setCustom(String custom) {
    this.custom = custom;
  }


}
