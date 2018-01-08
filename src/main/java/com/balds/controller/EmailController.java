package com.balds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.balds.controllerInterface.EmailControllerInterface;
import com.balds.dao.EmailDAO;
import com.balds.objects.Email;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class EmailController implements EmailControllerInterface {

	@Autowired
	EmailDAO emailDAO;
	
	@Override
	public @ResponseBody boolean sendEmailWebService(@RequestBody Email email) throws Exception {
		return emailDAO.sendEmail(email);
	}

}
