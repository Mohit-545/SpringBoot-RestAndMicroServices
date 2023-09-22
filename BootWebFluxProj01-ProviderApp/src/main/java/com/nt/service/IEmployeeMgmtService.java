//IEmployeeMgmtService.java
package com.nt.service;

import com.nt.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmployeeMgmtService {
	
	public Mono<Employee> saveEmployee(Employee emp);
	public Flux<Employee> getAllEmployees();
	public Mono<Employee> findEmpById(Integer id);
	public Mono<Void> removeEmployee(Integer id);

}//interface
