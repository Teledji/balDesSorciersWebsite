package com.balds.mariadb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.balds.objects.Person;

@Component
public interface PersonRepository extends CrudRepository<Person, Integer>{

}
