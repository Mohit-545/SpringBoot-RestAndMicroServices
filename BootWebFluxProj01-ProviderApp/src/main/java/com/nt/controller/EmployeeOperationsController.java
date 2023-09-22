//EmployeeOperationsController.java
package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationsController {
	@Autowired
	private IEmployeeMgmtService service;
	
	@PostMapping("/save")
	public Mono<Employee> saveOneEmployee(@RequestBody Employee emp){
		System.out.println("save(-) :: "+Thread.currentThread().hashCode());
		Mono<Employee> mono = service.saveEmployee(emp);
		return mono;
	}//method
	
	@GetMapping("/getAll")
	public Flux<Employee> getAllEmployee(){
		System.out.println("get(-) :: "+Thread.currentThread().hashCode());
		Flux<Employee> flux = service.getAllEmployees();
		return flux;
	}//method
	
	@GetMapping("/one/{id}")
	public Mono<Employee> getOneEmployee(@PathVariable Integer id){
		System.out.println("one(-) :: "+Thread.currentThread().hashCode());
		Mono<Employee> mono = service.findEmpById(id);
		return mono;
	}//method
	
	@DeleteMapping("/remove/{id}")
	public Mono<Void> deleteEmployee(@PathVariable Integer id){
		System.out.println("remove(-) :: "+Thread.currentThread().hashCode());
		Mono<Void> mono = service.removeEmployee(id);
		return mono;
	}//class

}//class
