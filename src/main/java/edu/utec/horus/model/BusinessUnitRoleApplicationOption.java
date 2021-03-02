package edu.utec.horus.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "business_unit_role_application_option",
    comment = "Main table association. This table create the relation between business unit, role ,application and option",
    uniqueConstraints = @UniqueConstraint(
        columnNames = {"businessUnit_id", "role_id", "application_id", "option_id"}))
public class BusinessUnitRoleApplicationOption extends Identifiable {

  @OneToOne
  private BusinessUnit businessUnit;

  @OneToOne
  private Role role;

  @OneToOne
  private Application application;

  @OneToOne
  private Option option;

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Application getApplication() {
    return application;
  }

  public void setApplication(Application application) {
    this.application = application;
  }

  public Option getOption() {
    return option;
  }

  public void setOption(Option option) {
    this.option = option;
  }

  public BusinessUnit getBusinessUnit() {
    return businessUnit;
  }

  public void setBusinessUnit(BusinessUnit businessUnit) {
    this.businessUnit = businessUnit;
  }

}
