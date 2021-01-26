package com.clinton.jobscheduling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinton.jobscheduling.domain.Person;
@Repository
public interface PersonDao extends JpaRepository<Person, Integer>{

}
