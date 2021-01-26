package com.clinton.jobscheduling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinton.jobscheduling.domain.Person;
import com.clinton.jobscheduling.repository.PersonDao;

@Service
public class PersonServiceImplementation implements PersonService{
	

	@Autowired
	PersonDao personDao;
	@Autowired
	public PersonServiceImplementation(PersonDao personDao) {
	this.personDao = personDao;
	}

	public List<Person> findAllPerson() {
		return personDao.findAll();
	}

	public void savePerson(Person person) {
		personDao.save(person);		
	}

	public void updatePerson(Person person) {
		personDao.save(person);
		
	}

	public void deletePerson(int id) {
		personDao.deleteById(id);		
	}

}
