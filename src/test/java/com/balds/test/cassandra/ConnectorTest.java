package com.balds.test.cassandra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.balds.cassandra.CassandraConnector;
import com.datastax.driver.core.ResultSet;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ConnectorTest {
	
	CassandraConnector cassandraConnector;
	
	@Before
	public void init() {
		cassandraConnector = new CassandraConnector();
	}
	
	@Test
	public void whenCreatingAKeyspace_thenCreated() {
//	    String keyspaceName = "library";
//	 
//	    ResultSet result = 
//	    		cassandraConnector.getSession().execute("SELECT * FROM mytestkeyspace;");
//	 
//	    List<String> matchedKeyspaces = result.all()
//	      .stream()
//	      .filter(r -> r.getString(0).equals(keyspaceName.toLowerCase()))
//	      .map(r -> r.getString(0))
//	      .collect(Collectors.toList());
//	 
//	    assertEquals(matchedKeyspaces.size(), 1);
//	    assertTrue(matchedKeyspaces.get(0).equals(keyspaceName.toLowerCase()));
	}
}
