package com.sougata.attendance.component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sougata.attendance.entity.DeviceAttendance;
import com.sougata.attendance.entity.User;
import com.sougata.attendance.entity.UserDeviceEffort;
import com.sougata.attendance.repository.DeviceAttendanceRepository;

@Component
public class DeviceAttendanceDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceAttendanceDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    DeviceAttendanceRepository deviceAttendanceRepository;

    @Transactional(readOnly = true)
    public List<DeviceAttendance> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<DeviceAttendance> DeviceAttendanceList = new ArrayList<DeviceAttendance>();
	for (DeviceAttendance DeviceAttendance : deviceAttendanceRepository.findAll()) {
	    LOGGER.info("DeviceAttendance : " + DeviceAttendance);
	    DeviceAttendanceList.add(DeviceAttendance);

	}
	return DeviceAttendanceList;

    }

    @Transactional(readOnly = true)
    public List<DeviceAttendance> findByUser(User user) {
	for (DeviceAttendance DeviceAttendance : deviceAttendanceRepository.findByUser(user)) {
	    LOGGER.info("DeviceAttendance : " + DeviceAttendance);
	}
	return deviceAttendanceRepository.findByUser(user);
    }

    @Transactional(readOnly = true)
    public DeviceAttendance findDeviceAttendanceById(Long id) {
//	for (DeviceAttendance DeviceAttendance : deviceAttendanceRepository.findById(id)) {
//	    LOGGER.info("DeviceAttendance : " + DeviceAttendance);
//	}
	return deviceAttendanceRepository.findById(id).get();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addDeviceAttendance(DeviceAttendance deviceAttendance) {

	LOGGER.info("in dao for inserting  device attendance");
	
	deviceAttendanceRepository.addDeviceAttendance(deviceAttendance);
	LOGGER.info("DeviceAttendance added successfully " + deviceAttendance.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteDeviceAttendance(Long deviceAttendanceId) {
	deviceAttendanceRepository.deleteDeviceAttendance(deviceAttendanceId);
	LOGGER.info("DeviceAttendance with id " + deviceAttendanceId + " deleted successfully ");
    }
    
    @Transactional(readOnly = true)
    public List<UserDeviceEffort> groupByUserAndDate(Date attendanceDate) {
	for (UserDeviceEffort DeviceAttendance : deviceAttendanceRepository.groupByUserAndDate(attendanceDate)) {
	    LOGGER.info("DeviceAttendance from groupByUserAndDate  : " + DeviceAttendance.toString());
	}
	return deviceAttendanceRepository.groupByUserAndDate(attendanceDate);
    }

}
