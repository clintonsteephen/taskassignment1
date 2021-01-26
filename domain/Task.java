package com.clinton.jobscheduling.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TASKK")
public class Task 
{
	@Id
	@GeneratedValue
	private int id;
	
	private String name; 
	private String description;
	@ManyToOne
	private Person assignedto;
	@Enumerated(EnumType.STRING)
	private Taskstatus taskstatus;
	public Task() {
		super();
	}
	public Task(int id, String name, String description, Person assignedto, Taskstatus taskstatus) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.assignedto = assignedto;
		this.taskstatus = taskstatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Person getAssignedto() {
		return assignedto;
	}
	public void setAssignedto(Person assignedto) {
		this.assignedto = assignedto;
	}
	public Taskstatus getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(Taskstatus taskstatus) {
		this.taskstatus = taskstatus;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", assignedto=" + assignedto
				+ ", taskstatus=" + taskstatus + "]";
	}
	
	
	
}
