package com.clinton.jobscheduling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clinton.jobscheduling.domain.Person;
import com.clinton.jobscheduling.domain.Task;
import com.clinton.jobscheduling.service.TaskService;

@RestController
@RequestMapping("task")
public class TaskController {

	@Autowired
	TaskService taskService;
	

	@RequestMapping(value="findAllTask",method = RequestMethod.GET,produces="application/json" )
	public List<Task> findAllTask() {
		return taskService.findAllTask();
	}
	@RequestMapping(value="save",method = RequestMethod.POST,produces="application/json" )
	public void saveTask(@RequestBody Task task) {
		System.out.println("haiiiiii"+task);
		taskService.saveTask(task);
	}
	@RequestMapping(value="update",method = RequestMethod.POST,produces="application/json" )
	public void updateTask(@RequestBody Task task) {
		
		System.out.println("updated task ; "+task);
		taskService.updateTask(task);
	}
	@RequestMapping(value="delete/{id}",method = RequestMethod.DELETE,produces="application/json" )
	public void deleteTask(@PathVariable int id) {
		taskService.deleteTask(id);
	}
	@RequestMapping(value="findAllPerson",method = RequestMethod.GET,produces="application/json" )
	public List<Person> findAllPerson()
{
		return taskService.availableperson();
		}


}
