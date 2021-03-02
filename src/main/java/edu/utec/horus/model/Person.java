package edu.utec.horus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;

@Entity
@Table(name = "person", comment = "User in organization")
public class Person extends Identifiable {

  @Column(length = 50, unique = true, comment = "main identifier in country. In peru is dni")
  @Required
  private String mainIdentifier;

  @Column(length = 50, comment = "additional id of this person on another systems")
  private String externalId;

  @Column(length = 50, comment = "first name")
  @Required
  private String firstName;

  @Column(length = 50, comment = "if user has more than one first name")
  private String additionalFirstName;

  @Column(length = 50, comment = "lastname")
  @Required
  private String lastName;

  @Column(length = 50, comment = "if user has more than one last name")
  private String additionalLastName;

  @Stereotype("EMAIL")
  @Column(length = 50, unique = true, comment = "main email of person in the organization. Unique!")
  @Required
  private String email;

  @Column(comment = "Used for disable a person without delete it")
  @Required
  private boolean enabled = false;

  @Column(length = 150, comment = "custom field to store several fields in json format.")
  private String custom;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "position_id")
  private Position position;

  // @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  // @JoinTable(name = "person_business_unit", joinColumns = @JoinColumn(name = "person_id"),
  // inverseJoinColumns = @JoinColumn(name = "business_unit_id"))
  // private List<BusinessUnit> businessUnits = new ArrayList<>();
  //
  // @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  // @JoinTable(name = "person_profile", joinColumns = @JoinColumn(name = "person_id"),
  // inverseJoinColumns = @JoinColumn(name = "profile_id"))
  // private List<Profile> profiles = new ArrayList<>();

  // @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "profile_id")
  // private Profile profile;

  public String getMainIdentifier() {
    return mainIdentifier;
  }

  public void setMainIdentifier(String mainIdentifier) {
    this.mainIdentifier = mainIdentifier;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getAdditionalFirstName() {
    return additionalFirstName;
  }

  public void setAdditionalFirstName(String additionalFirstName) {
    this.additionalFirstName = additionalFirstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAdditionalLastName() {
    return additionalLastName;
  }

  public void setAdditionalLastName(String additionalLastName) {
    this.additionalLastName = additionalLastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public String getCustom() {
    return custom;
  }

  public void setCustom(String custom) {
    this.custom = custom;
  }



}
