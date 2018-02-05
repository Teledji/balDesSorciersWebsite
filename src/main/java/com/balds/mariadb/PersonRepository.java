package com.balds.mariadb;

import org.springframework.data.repository.CrudRepository;
import com.balds.objects.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	Person findByPersonid(int personid);
}
