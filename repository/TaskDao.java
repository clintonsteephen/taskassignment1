package com.clinton.jobscheduling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clinton.jobscheduling.domain.Task;

@Repository
public interface TaskDao extends JpaRepository<Task, Integer>{
	
	
	@Query(value="select * from taskk where taskstatus !='ASSIGNED'",nativeQuery=true)
	public List<Task> availableperson();

}
