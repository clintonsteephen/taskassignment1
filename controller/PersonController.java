package com.clinton.jobscheduling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;

import com.clinton.jobscheduling.domain.Person;
import com.clinton.jobscheduling.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController 
{
	@Autowired
	PersonService personService;
	
	/*@PostMapping("/add")
	public void add(@RequestBody Person person)
	{
		System.out.println("fsdgsg");
	}*/
	
	@RequestMapping(value="findAllPerson",method = RequestMethod.GET,produces="application/json" )
	public List<Person> findAllPesrson() {
		return personService.findAllPerson();
	}
	@RequestMapping(value="save",method = RequestMethod.POST,produces="application/json" )
	public void savePerson(@RequestBody Person person) {
		System.out.println("haiiiiii"+person);
		personService.savePerson(person);
	}

	@RequestMapping(value="update",method = RequestMethod.GET,produces="application/json" )
	public void updatePesron(@RequestBody Person person) {
		
		System.out.println("updated person ; "+person);
		personService.updatePerson(person);
	}
	@RequestMapping(value="delete/{id}",method = RequestMethod.GET,produces="application/json" )
	public void deletePerson(@PathVariable int id) {
		personService.deletePerson(id);
	}

}
