package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Result;
import com.example.cassandra.CassandraConnector;
import com.example.cassandra.PersonTable;
import com.example.controllerInterface.PersonControllerInterface;
import com.example.dao.PersonDAO;
import com.example.objects.Person;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;



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
	public @ResponseBody PersonTable getCustomerByIdWebService(@PathVariable int personid) throws Exception{
		return personDAO.getCustomerById(personid);
	}
	
	@Override
	public @ResponseBody boolean insertNewCustomerWebService(@RequestBody PersonTable person) throws Exception {
		return personDAO.insertNewCustomer(person);
	}
	
	
}
