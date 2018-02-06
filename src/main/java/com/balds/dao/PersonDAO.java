package com.balds.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.balds.mariadb.PersonRepository;
import com.balds.objects.Person;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;

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
		String sql = "INSERT INTO person"
				+ "(personID, firstName, lastName, email, birthdate, houseID)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/baldessorciers", "root", "BalDesSorciers");
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setInt(1, person.getPersonid());
		preparedStatement.setString(2, person.getFirstName());
		preparedStatement.setString(3, person.getLastName());
		preparedStatement.setString(4, person.getEmail());
		preparedStatement.setDate(5, person.getBirthDate());
		preparedStatement.setInt(6, person.getHouse().getHouseID());
		int resultat = preparedStatement.executeUpdate();
		System.out.println(resultat);
		return false;
		//return (personRepository.save(person)) == null ? false : true;
	}
}
