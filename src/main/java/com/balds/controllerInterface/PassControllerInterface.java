package com.balds.controllerInterface;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.balds.objects.Person;

public interface PassControllerInterface {
	
	@PostMapping("/pass")
	public @ResponseBody boolean insertNewPassWebService(@RequestBody Person person) throws Exception;
}
