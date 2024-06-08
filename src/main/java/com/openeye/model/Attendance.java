package com.openeye.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long attendanceId;

	private String employeeId;

	private String employeerAssociateId;

	private ATTENDANCE_STATUS attendanceStatus;

	private LocalDateTime localDateTime;

	private boolean imageCaptured;

	public Attendance() {
		super();
	}

	public Attendance(long attendanceId, String employeeId, String employeerAssociateId, ATTENDANCE_STATUS attendanceStatus,
			LocalDateTime localDateTime, boolean imageCaptured) {
		super();
		this.attendanceId = attendanceId;
		this.employeeId = employeeId;
		this.employeerAssociateId = employeerAssociateId;
		this.attendanceStatus = attendanceStatus;
		this.localDateTime = localDateTime;
		this.imageCaptured = imageCaptured;
	}

	public long getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(long attendanceId) {
		this.attendanceId = attendanceId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public ATTENDANCE_STATUS getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(ATTENDANCE_STATUS attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public boolean isImageCaptured() {
		return imageCaptured;
	}

	public void setImageCaptured(boolean imageCaptured) {
		this.imageCaptured = imageCaptured;
	}

	public String getEmployeerAssociateId() {
		return employeerAssociateId;
	}

	public void setEmployeerAssociateId(String employeerAssociateId) {
		this.employeerAssociateId = employeerAssociateId;
	}

}
