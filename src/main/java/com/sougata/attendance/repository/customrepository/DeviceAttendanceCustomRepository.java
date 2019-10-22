package com.sougata.attendance.repository.customrepository;

import java.sql.Date;
import java.util.List;

import com.sougata.attendance.entity.DeviceAttendance;
import com.sougata.attendance.entity.UserDeviceEffort;

public interface DeviceAttendanceCustomRepository {

    DeviceAttendance getDeviceAttendanceById(Long attendanceId);

    void deleteDeviceAttendance(Long attendanceId);

    void updateDeviceAttendance(DeviceAttendance deviceAttendance);

    void addDeviceAttendance(DeviceAttendance deviceAttendance);

    List<DeviceAttendance> getAllDeviceAttendances();
    
    List<UserDeviceEffort> groupByUserAndDate(Date attendanceDate);

}
