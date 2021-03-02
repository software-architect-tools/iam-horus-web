package edu.utec.horus.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "person_business_unit_profile",
    comment = "Main table association. This table create the relation between person, business unit and profile",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"person_id", "businessUnit_id", "profile_id"}))
public class PersonBusinessUnitProfile extends Identifiable {

  @OneToOne
  private Person person;

  @OneToOne
  private BusinessUnit businessUnit;

  @OneToOne
  private Profile profile;

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public BusinessUnit getBusinessUnit() {
    return businessUnit;
  }

  public void setBusinessUnit(BusinessUnit businessUnit) {
    this.businessUnit = businessUnit;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }


}
