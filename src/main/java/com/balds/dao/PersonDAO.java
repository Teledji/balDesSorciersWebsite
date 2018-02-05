package com.balds.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.balds.mariadb.PersonRepository;
import com.balds.objects.Person;

@Component
public class PersonDAO{
	
	@Autowired
	private PersonRepository personRepository;

	public Integer getCustomerAge(int personid) {
		return -1;
	}
	
	public Person getCustomerById(int personid) throws Exception {
		return null;
	}
	
	public boolean insertNewCustomer(Person person) throws Exception {
		return (personRepository.save(person)) == null ? false : true;
	}
}
