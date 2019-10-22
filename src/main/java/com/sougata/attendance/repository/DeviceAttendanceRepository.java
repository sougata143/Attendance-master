package com.sougata.attendance.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sougata.attendance.entity.DeviceAttendance;
import com.sougata.attendance.entity.User;
import com.sougata.attendance.repository.customrepository.DeviceAttendanceCustomRepository;

public interface DeviceAttendanceRepository
	extends CrudRepository<DeviceAttendance, Long>, DeviceAttendanceCustomRepository {

    Optional<DeviceAttendance> findById(Long i);

    List<DeviceAttendance> findByUser(User user);
    
    List<DeviceAttendance> findByUserAndAttendanceDate(User user,Date attendanceDate);

}
