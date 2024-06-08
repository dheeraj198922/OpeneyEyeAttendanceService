package com.openeye.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openeye.model.ATTENDANCE_STATUS;
import com.openeye.model.Attendance;
import com.openeye.service.MarkAttendanceService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/attendance/markAttendance")
public class MarkAttendanceController {

	private static final String RESILIENCE4J_INSTANCE_NAME = "employeeResilience4j";
	@Autowired
	MarkAttendanceService attendanceService;

	@PostMapping("/employee/{employeeId}")
	@CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = RESILIENCE4J_INSTANCE_NAME)
	public ResponseEntity<Attendance> markAttendance(@PathVariable String employeeId ) {
		
		Attendance markAttendance = attendanceService.markAttendance(employeeId);
		return new ResponseEntity<Attendance>(markAttendance, HttpStatus.CREATED);
	}

	
	public ResponseEntity<Attendance> employeeResilience4j(String employeeId, Exception exception){
		Attendance markAttendance = new Attendance();
		markAttendance.setEmployeeId(exception.getMessage());
		markAttendance.setAttendanceId(0l);
		markAttendance.setAttendanceStatus(ATTENDANCE_STATUS.UNMARKED);
		markAttendance.setImageCaptured(false);
		markAttendance.setLocalDateTime(LocalDateTime.now());
		return new ResponseEntity<Attendance>(markAttendance, HttpStatus.CREATED);
	}
}
