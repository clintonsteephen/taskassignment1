package com.clinton.jobscheduling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity

@Table(name = "PERSONN")
public class Person {
	
	@Id
	@GeneratedValue
	private int id;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}

	private String fName;
	private String lName;
	private String uName;
	
	public Person(int id, String fName, String lName, String uName) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.uName = uName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", fName=" + fName + ", lName=" + lName + ", uName=" + uName + "]";
	}
	
	

}
