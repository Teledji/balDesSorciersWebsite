package com.balds.controllerInterface;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.balds.cassandra.PersonTable;

public interface PersonControllerInterface {

	@GetMapping("/customer/age/{personid}")
	public @ResponseBody Integer getCustomerAgeWebService(
			@RequestParam(required=true) @PathVariable int personid);

	@GetMapping("/customer/{personid}")
	public @ResponseBody PersonTable getCustomerByIdWebService(
			@RequestParam(required=true) @PathVariable int personid) throws Exception;

	@PostMapping("/customer")
	public @ResponseBody boolean insertNewCustomerWebService(@RequestBody PersonTable person) throws Exception;
}
