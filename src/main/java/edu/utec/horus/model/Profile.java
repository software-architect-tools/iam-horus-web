package edu.utec.horus.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.openxava.annotations.Required;

@Entity
@Table(name = "profile", comment = "Profile required for any person for security relationship")
public class Profile extends Identifiable {

  @Column(length = 50, comment = "string without spaces. Used for external clients")
  @Required
  private String identifier;

  @Column(length = 50, unique = true, comment = "profile name")
  @Required
  private String name;

  @Column(length = 50, comment = "profile description")
  private String description;

//  @OneToMany(mappedBy = "profile")
//  private List<Person> persons = new ArrayList<>();

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "profile_role", joinColumns = @JoinColumn(name = "profile_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<Role> roles = new ArrayList<>();

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

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }
}
