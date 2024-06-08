package com.openeye.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.openeye.model.Employee;
//
//@FeignClient(value = "employee", url = "http://localhost:8081")
@FeignClient("EMPLOYEE-SERVICE")
public interface EmployeeClient {
	//@GetMapping("/{employeeId}")
	
	  @RequestMapping(method = RequestMethod.GET, value = "/employee/{employeeId}")
	  Employee getEmployee(@PathVariable("employeeId") String employeeId);
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/employee")
	 List<Employee> getEmployees();
}
