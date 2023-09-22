//EmployeeMgmtServiceImpl.java
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public Mono<Employee> saveEmployee(Employee emp) {
		return empRepo.save(emp).switchIfEmpty(Mono.empty());
	}//method

	@Override
	public Flux<Employee> getAllEmployees() {
		return empRepo.findAll().switchIfEmpty(Flux.empty());
	}//method

	@Override
	public Mono<Employee> findEmpById(Integer id) {
		return empRepo.findById(id).switchIfEmpty(Mono.empty());
	}//method

	@Override
	public Mono<Void> removeEmployee(Integer id) {
		return empRepo.deleteById(id);
	}//method

}//class
