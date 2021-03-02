package edu.utec.horus.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.openxava.annotations.Required;

@Entity
@Table(name = "position", comment = "User clasification inside organization")
public class Position extends Identifiable {

  @Column(length = 50, comment = "string without spaces. Used for external clients")
  @Required
  private String identifier;  
  
  @Column(length = 50, unique = true, comment = "position name")
  @Required
  private String name;

  @Column(length = 50, comment = "position description")
  private String description;

  @OneToMany(mappedBy = "position")
  private List<Person> persons = new ArrayList<>();

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
