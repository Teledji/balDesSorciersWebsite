package com.balds.dao;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.balds.cassandra.CassandraConnector;
import com.balds.cassandra.PersonTable;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Result;

@Component
public class PersonDAO {
	
	@Autowired
	CassandraConnector cassandraConnector;

	public Integer getCustomerAge(int personid) {
		Statement statement = QueryBuilder
				.select("age")
				.from("mytestkeyspace", "person")
				.where(eq("personid", personid));
		Row result = cassandraConnector.getSession().execute(statement).one();
		return result != null ? result.get("age", Integer.class) : -1;
	}
	
	public PersonTable getCustomerById(int personid) throws Exception {
		List<Row> result = null;
		PersonTable person = new PersonTable();
		Statement statement = QueryBuilder
				.select()
				.from("mytestkeyspace", "person")
				.where(eq("personid", personid));
		try {
			result = cassandraConnector.getSession().execute(statement).all();
			for(Row row : result) {
				person.setPersonid(row.getInt(0));
				person.setAddress(row.getString(1));
				person.setAge(row.getInt(2));
				person.setFirstName(row.getString(3));
				person.setLastName(row.getString(4));	
			}			
		} catch (Exception e) {
			throw new Exception("Failed to search Student for studentId :" + personid, e);
		}
		
		return result.size() > 0 ? person : null;
	}
	
	public boolean insertNewCustomer(PersonTable person) throws Exception {
		String[] columnName = {"personid", "first_name", "last_name", "age", "address"};
		try{
			Object[] values = {person.getPersonid(), 
					person.getFirstName(), 
					person.getLastName(), 
					person.getAge(), 
					person.getAddress()};//{personIdToInt, firstName, lastName, ageToInt, address};
			Statement statement = QueryBuilder
				.insertInto("mytestkeyspace", "person")
				.values(columnName, values);
			ResultSet resultSet = cassandraConnector.getSession().execute(statement);
			return resultSet.wasApplied();		
		} 
		catch(Exception e) {
			throw new Exception("Failed to insert ! Error: " + e.getMessage());
		}
	}
}
