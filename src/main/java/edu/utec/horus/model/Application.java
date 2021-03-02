package edu.utec.horus.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.openxava.annotations.Required;

@Entity
@Table(name = "application", comment = "application web, api, mobile, etc")
public class Application extends Identifiable {

  @Column(length = 50, unique = true, comment = "app identifier. Not spaces are allowed")
  @Required
  private String identifier;

  @Column(length = 50, comment = "application name")
  @Required
  private String name;

  @Column(length = 50, comment = "short description about application")
  @Required
  private String description;

  @Column(length = 25, comment = "application type: WEB, API, MOBILE, DESKTOP, IOT, IA, GENERIC")
  @Enumerated(EnumType.STRING)
  private ApplicationType applicationType;

  @Column(length = 50, comment = "application http domain")
  private String domain;

  @OneToMany(mappedBy = "application")
  private List<Option> applicationOptions = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ApplicationType getApplicationType() {
    return applicationType;
  }

  public void setApplicationType(ApplicationType applicationType) {
    this.applicationType = applicationType;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

}
