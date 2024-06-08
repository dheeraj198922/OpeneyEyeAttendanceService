package com.openeye.model;


public class AttendanceResponse {

	private ATTENDANCE_STATUS attendanceStatus;

	private String message;

	public AttendanceResponse() {
		super();
	}

	public AttendanceResponse(ATTENDANCE_STATUS attendanceStatus, String message) {
		super();
		this.attendanceStatus = attendanceStatus;
		this.message = message;
	}

	public ATTENDANCE_STATUS getAttendanceStatus() {
		return attendanceStatus;
	}

	public void setAttendanceStatus(ATTENDANCE_STATUS attendanceStatus) {
		this.attendanceStatus = attendanceStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
