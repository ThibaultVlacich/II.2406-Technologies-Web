package lab.mvc.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Serializable {
  String firstName;
  String lastName;
  String birthDate;
  String sex;
  
  public Person(String firstName, String lastName, String birthDate, String sex) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.sex = sex;
  }
  
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
  
  public int getBirthYear() {
    if (birthDate != null) {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      
      try {
        Date date = formatter.parse(birthDate);
        
        return date.getYear();
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }
    
    return 0;
  }
  
  public String getSex() {
    return sex;
  }
  
  public void setSex(String sex) {
    this.sex = sex;
  }
  
}
