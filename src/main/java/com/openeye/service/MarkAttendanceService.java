package com.openeye.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

import com.openeye.model.ATTENDANCE_STATUS;
import com.openeye.model.Attendance;
import com.openeye.model.CaptureImage;
import com.openeye.model.Employee;
import com.openeye.repository.AttendanceRepository;

@Service
public class MarkAttendanceService {

	@Autowired
	ImageClient imageClient;

	@Autowired
	EmployeeClient employeeClient;

	@Autowired
	AttendanceRepository attendanceRepository;


	public Attendance markAttendance(String employeeId) {

		// TODO- bring employee details based on employeeId and check employee is active
		// or not
		/* Employee employee = employeeClient.getEmployee(Long.getLong(employeeId)); */
		Employee employee = employeeClient.getEmployee(employeeId);
		/* Employee employee = employeeClient.getEmployees().get(1); */
		// TODO - bring the image capture details

		CaptureImage capturedEmployeeDetails = imageClient.capturedEmployeeDetails(employeeId);

		// TODO- if employee is active and image is capture for the particular employee
		// then mark the attendance.
		Attendance attendanceStatus = new Attendance();
		if (employee.isActive() && capturedEmployeeDetails.isCapturedSuccessfully()) {
			// mark attendance.
			Attendance attendance = new Attendance(1l, employee.getEmployeeId().toString(),
					employee.getEmployeerAssociateId(), ATTENDANCE_STATUS.MARKED, LocalDateTime.now(), false);
			attendanceStatus = attendanceRepository.save(attendance);
			return attendanceStatus;

		}
		return attendanceStatus;
	}

}
