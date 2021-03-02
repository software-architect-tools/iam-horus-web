package edu.utec.horus.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.openxava.annotations.Required;

// TODO: If this table has the name of Option, framework
// show this error: Impossible to execute Init list action: Transaction marked as rollbackOnly
// solution : Use Options instead Option
@Entity
@Table(name = "options", comment = "Option of an application: endpoint, web, mobile option, etc",
    uniqueConstraints = @UniqueConstraint(columnNames = {"application_id", "identifier"}))
public class Option extends Identifiable {

  @Column(length = 50, unique = true, comment = "string without spaces. Used for external clients")
  @Required
  private String identifier;

  @Column(length = 50, comment = "option name")
  @Required
  private String name;

  @Column(length = 150, comment = "option description used as optional label in clients")
  @Required
  private String description;

  @Column(length = 150, name = "optionValue", comment = "option main value")
  private String value;

  @Column(comment = "order used for web clients")
  private int optionalOrder;

  @Column(length = 25,
      comment = "option type: REST_ENDPOINT, WEB_OPTION, MOBILE_OPTION, INTERNAL_RULE")
  @Enumerated(EnumType.STRING)
  private OptionType type;

  @Column(length = 25,
      comment = "option http method: NOT_HTTP_METHOD, GET, HEAD, POST, PUT, DELETE, CONNECT ,OPTIONS, TRACE")
  @Enumerated(EnumType.STRING)
  private HttpMethod httpMethod;

  @Column(comment = "Used to determine if this option is from a legacy system")
  @Required
  private boolean legacy;

  @Column(length = 150, comment = "custom field to store several fields in json format.")
  private String custom;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "options_id", referencedColumnName = "id")
  private Option parentOption;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "application_id")
  private Application application;

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

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public Application getApplication() {
    return application;
  }

  public void setApplication(Application application) {
    this.application = application;
  }

  public OptionType getType() {
    return type;
  }

  public void setType(OptionType type) {
    this.type = type;
  }

  public HttpMethod getHttpMethod() {
    return httpMethod;
  }

  public void setHttpMethod(HttpMethod httpMethod) {
    this.httpMethod = httpMethod;
  }

  public Option getParentOption() {
    return parentOption;
  }

  public void setParentOption(Option parentOption) {
    this.parentOption = parentOption;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public int getOptionalOrder() {
    return optionalOrder;
  }

  public void setOptionalOrder(int optionalOrder) {
    this.optionalOrder = optionalOrder;
  }

  public boolean isLegacy() {
    return legacy;
  }

  public void setLegacy(boolean legacy) {
    this.legacy = legacy;
  }

  public String getCustom() {
    return custom;
  }

  public void setCustom(String custom) {
    this.custom = custom;
  }
}
