package edu.utec.horus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.openxava.annotations.Required;

@Entity
@Table(name = "business_unit", comment = "Business unit of organization")
public class BusinessUnit extends Identifiable {

  @Column(length = 50, unique = true, comment = "string without spaces. Used for external clients")
  @Required
  private String identifier;

  @Column(length = 50, unique = true, comment = "Business unit name")
  @Required  
  private String name;

  @Column(length = 50, comment = "Business unit description")
  private String description;

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

}
