package com.clinton.jobscheduling.service;

import java.util.List;

import com.clinton.jobscheduling.domain.Person;


public interface PersonService {
	
	public List<Person> findAllPerson();
	public void savePerson(Person person);
	public void updatePerson(Person person);
	public void deletePerson(int id);



}
