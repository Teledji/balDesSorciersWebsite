package com.balds.controllerInterface;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.balds.cassandra.PersonTable;
import com.balds.objects.Person;

public interface PersonControllerInterface {

	@GetMapping("/customer/age/{personid}")
	public @ResponseBody Integer getCustomerAgeWebService(
			@RequestParam(required=true) @PathVariable int personid);

	@GetMapping("/customer/{personid}")
	public @ResponseBody Person getCustomerByIdWebService(
			@RequestParam(required=true) @PathVariable int personid) throws Exception;

	@PostMapping("/customer")
	public @ResponseBody boolean insertNewCustomerWebService(@RequestBody Person person) throws Exception;
}
