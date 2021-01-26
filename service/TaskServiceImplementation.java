package com.clinton.jobscheduling.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinton.jobscheduling.domain.Person;
import com.clinton.jobscheduling.domain.Task;
import com.clinton.jobscheduling.domain.Taskstatus;
import com.clinton.jobscheduling.repository.PersonDao;
import com.clinton.jobscheduling.repository.TaskDao;


@Service
public class TaskServiceImplementation implements TaskService{

	TaskDao taskDao;
	@Autowired
	PersonDao personDao;
	
@Autowired
 public TaskServiceImplementation(TaskDao taskdao ,PersonDao personDao) {
	this.taskDao=taskdao;
	this.personDao=personDao;
	
	
}
	@Override
	public List<Task> findAllTask() {
		return taskDao.findAll();
	
	}

	@Override
	public void saveTask(Task task) {
		//taskDao.save(task);
		int flag=0;
		Person i=task.getAssignedto();
		int pid=i.getId();
		if(pid==0) 
		{
			task.setTaskstatus(Taskstatus.NEW);
			task.setAssignedto(null);
			System.out.println(task);
			taskDao.save(task);
		}
		else 
		{
			List<Task>tasklist=taskDao.findAll();
			List<Person>personlist=personDao.findAll();
			for(Task taskobj:tasklist) 
			{
				if(taskobj.getAssignedto()!=null) 
				{
					if(taskobj.getAssignedto().getId()==pid && taskobj.getTaskstatus()==Taskstatus.DONE) 
					{
						task.setTaskstatus(Taskstatus.ASSIGNED);
						task.setAssignedto(taskobj.getAssignedto());
						flag=1;
					}
					else if(taskobj.getAssignedto().getId()==pid && taskobj.getTaskstatus()==Taskstatus.ASSIGNED)
					{
						task.setTaskstatus(Taskstatus.NEW);
						task.setAssignedto(null);
						flag=0;
						taskDao.save(task);
						break;
						
					}
				}
			}
			if(flag==1) 
			{
				for(Person personobj:personlist)
				{
					if(pid==personobj.getId()) 
					{
						taskDao.save(task);
					}
				}
			}
				
		}
	}

	@Override
	public void updateTask(Task task) {
		/*Taskstatus status=task.getTaskstatus();
		Taskstatus status1=Taskstatus.DONE;
		if(status==status1) 
		{
			task.setAssignedto(null);
		}
		*/
		
		taskDao.save(task);
		
	}

	@Override
	public void deleteTask(int id) {
		taskDao.deleteById(id);
		
	}
	@Override
	public List <Person> availableperson() {
		List <Task> tasklist = taskDao.availableperson();
		List <Person> personlist=personDao.findAll();
		
		for(Task i : tasklist) { // ConcurrentModificationException
			  Iterator iterator = personlist.iterator();
			  while(iterator.hasNext()) {    
			     Person n = (Person) iterator.next();
			     if(n.getId()==i.getAssignedto().getId()) {
			         iterator.remove();      
			     }
			  }
			}

			for(Person taskk:personlist) {
			System.out.println(">>>>>>>>>"+taskk);
			}
	

		return personlist;
	}
	
	

}
