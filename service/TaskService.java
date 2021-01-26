package com.clinton.jobscheduling.service;

import java.util.List;

import com.clinton.jobscheduling.domain.Person;
import com.clinton.jobscheduling.domain.Task;

public interface TaskService {
	public List<Task> findAllTask();
	public void saveTask(Task task);
	public void updateTask(Task task);
	public void deleteTask(int id);
	public List<Person> availableperson();

}
