//EmployeeRepository.java
package com.nt.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nt.model.Employee;

public interface IEmployeeRepository extends ReactiveMongoRepository<Employee, Integer> {

}//interface
