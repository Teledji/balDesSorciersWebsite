package com.example.cassandra;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;

import org.springframework.stereotype.Component;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Session;

@Component
public class CassandraConnector {
	
	private Cluster cluster;
	private Session session;
	private MappingManager  mappingManager;
	private Mapper < PersonTable > mapper;
	
	public CassandraConnector(){
		connect();
		mappingManager = new MappingManager(session);
		mapper = mappingManager.mapper(PersonTable.class);
	}
	
	private void connect() {
	    this.connect("127.0.0.1", 9042);
	    this.session = this.getSession();
	}
	
	public void connect(String node, Integer port) {
        Builder b = Cluster.builder().addContactPoint(node);
        if (port != null) {
            b.withPort(port);
        }
        cluster = b.build();
 
        session = cluster.connect();
    }
	
	public void close() {
        session.close();
        cluster.close();
    }
	
	public Session getSession() {
        return this.session;
    }
	
	public MappingManager getMappingManager() {
		return mappingManager;
	}

	public void setMappingManager(MappingManager mappingManager) {
		this.mappingManager = mappingManager;
	}

	public Mapper<PersonTable> getMapper() {
		return mapper;
	}

	public void setMapper(Mapper<PersonTable> mapper) {
		this.mapper = mapper;
	}
}


