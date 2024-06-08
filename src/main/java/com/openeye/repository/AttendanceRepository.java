package com.openeye.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openeye.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
