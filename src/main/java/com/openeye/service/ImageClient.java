package com.openeye.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.openeye.model.CaptureImage;

@FeignClient(value = "images", url = "http://localhost:8083")
public interface ImageClient {
	 @RequestMapping(method = RequestMethod.GET, value = "/images/{employeeId}")
	//@GetMapping("/images/{employeeId}")
	public CaptureImage capturedEmployeeDetails(@PathVariable("employeeId") String employeeId);
}
