package com.openeye.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.openeye.model.Employee;
//
@FeignClient(value = "employee", url = "http://openeyeemployeeservice:9091",  path = "/employee")
//@FeignClient("openeyeemployeeservice")
public interface EmployeeClient {
	//@GetMapping("/{employeeId}")
	
	  @RequestMapping(method = RequestMethod.GET, value = "/{employeeId}")
	  Employee getEmployee(@PathVariable("employeeId") String employeeId);
	 
	 @RequestMapping(method = RequestMethod.GET)
	 List<Employee> getEmployees();
}
