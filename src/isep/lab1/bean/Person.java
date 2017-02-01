package isep.lab1.bean;

import java.io.Serializable;

public class Person implements Serializable {
  String firstName;
  String lastName;
  String birthDate;
  String sex;
  
  public String getFirstName() {
    return firstName;
  }
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getBirthDate() {
    return birthDate;
  }
  
  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }
  
  public String getSex() {
    return sex;
  }
  
  public void setSex(String sex) {
    this.sex = sex;
  }
  
}
