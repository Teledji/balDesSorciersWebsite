package com.balds.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.balds.controllerInterface.PassControllerInterface;
import com.balds.objects.Person;

@RestController
@CrossOrigin(origins = "http://localhost:9000") 
public class PassController implements PassControllerInterface {
	
	@Override
	public boolean insertNewPassWebService(Person person) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
