package com.balds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.balds.controllerInterface.PersonControllerInterface;
import com.balds.dao.PersonDAO;
import com.balds.objects.Person;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;



@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class PersonController implements PersonControllerInterface {
	
	@Autowired
	PersonDAO personDAO;
	
	@Override
	public @ResponseBody Integer getCustomerAgeWebService(@PathVariable int personid) {
		return personDAO.getCustomerAge(personid);
	}
	
	@Override
	public @ResponseBody Person getCustomerByIdWebService(@PathVariable int personid) throws Exception{
		return personDAO.getCustomerById(personid);
	}
	
	@Override
	public @ResponseBody boolean insertNewCustomerWebService(@RequestBody Person person) throws Exception {
		return personDAO.insertNewCustomer(person);
	}
	
	
}
