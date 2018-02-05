package com.balds.objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pass")
public class Pass {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int passID;
	private String name;
	private int price;
	private String description;
	
	public int getPassID() {
		return passID;
	}
	public void setPassID(int passID) {
		this.passID = passID;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
