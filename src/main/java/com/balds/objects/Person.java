package com.balds.objects;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int personid;
	private String firstName;
	private String lastName;
	private String email;
	private int age; 
	private Date birthDate;
	private String address;
	private House houseID;
	
	public Person() {
		
	}
	
	public Person(int personid, String firstName, String lastName, int age, String address) {
		this.personid = personid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
	}
	
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
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
	public void setLastName(String last_name) {
		this.lastName = last_name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public House getHouse() {
		return houseID;
	}

	public void setHouse(House house) {
		this.houseID = house;
	}
 
}
