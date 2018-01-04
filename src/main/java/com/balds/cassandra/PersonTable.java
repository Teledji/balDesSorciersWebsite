package com.balds.cassandra;



import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.Table;
import com.datastax.driver.mapping.annotations.PartitionKey;


@Table(name = "person", keyspace = "mytestkeyspace")
public class PersonTable {

	@PartitionKey @Column(name = "personid") 
	int personid;
	
	@Column(name = "first_name") 
	String firstName;
	
	@Column(name = "last_name") 
	String lastName;
	
	@Column(name = "age") 
	int age;
	
	@Column(name = "address") 
	String address;	
	
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
}
