package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID")
	private int id;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="PHONE")
	private String phone;
	@Column(name="HOME_ADDRESS")
	private String homeAddress;
	@Column(name="EMAIL")
	private String email;
	@Column(name="TERMINATION_DATE")
	private LocalDate terminationDate;

	public Employee() {
		
	}
	
	public Employee(String f, String l, String p, String h, String e) {
		this.setFirstName(f);
		this.setLastName(l);
		this.setPhone(p);
		this.setHomeAddress(h);
		this.setEmail(e);
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	
	public LocalDate getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(LocalDate terminationDate) {
		this.terminationDate = terminationDate;
	}
	
	public String getEmployeeDetails() {
		return "Employee ID: " + id + "\nName: " + firstName + " " + lastName + "\nAddress: " + homeAddress + "\nPhone: " + phone + "\nEmail: " + email + "\nTermination Date: " + terminationDate;
	}
}
