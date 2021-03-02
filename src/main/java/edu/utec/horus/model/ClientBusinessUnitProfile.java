package edu.utec.horus.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "client_business_unit_profile",
    comment = "Main table association. This table create the relation between client, business unit and profile",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"client_id", "businessUnit_id", "profile_id"}))
public class ClientBusinessUnitProfile extends Identifiable {

  @OneToOne
  private Client client;

  @OneToOne
  private BusinessUnit businessUnit;

  @OneToOne
  private Profile profile;

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
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
