package com.sougata.attendance.repository.repositoryimpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.attendance.entity.DeviceAttendance;
import com.sougata.attendance.entity.UserDeviceEffort;
import com.sougata.attendance.repository.customrepository.DeviceAttendanceCustomRepository;

@Transactional
@Repository
public class DeviceAttendanceRepositoryImpl implements DeviceAttendanceCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DeviceAttendance getDeviceAttendanceById(Long deviceAttendanceId) {
	return entityManager.find(DeviceAttendance.class, deviceAttendanceId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DeviceAttendance> getAllDeviceAttendances() {
	String hql = "FROM DeviceAttendance as deviceAttendance ORDER BY deviceAttendance.id";
	return (List<DeviceAttendance>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addDeviceAttendance(DeviceAttendance DeviceAttendance) {
	entityManager.merge(DeviceAttendance);
    }

    @SuppressWarnings("unused")
    @Override
    public void updateDeviceAttendance(DeviceAttendance DeviceAttendance) {
	DeviceAttendance DeviceAttendanceItem = getDeviceAttendanceById(DeviceAttendance.getId());
    }

    @Override
    public void deleteDeviceAttendance(Long DeviceAttendanceId) {
	entityManager.remove(getDeviceAttendanceById(DeviceAttendanceId));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserDeviceEffort> groupByUserAndDate(Date attendanceDate) {
	//"SELECT student.course, COUNT(student.course) FROM Student student GROUP BY student.course"
	String hql = "SELECT MAX(deviceAttendance.outTime),MIN(deviceAttendance.inTime),deviceAttendance.user.id,deviceAttendance.attendanceDate FROM DeviceAttendance as deviceAttendance GROUP BY deviceAttendance.user,deviceAttendance.attendanceDate";
	 List<UserDeviceEffort> userEfforList=new ArrayList<UserDeviceEffort>();
     System.out.println("value is" +entityManager.createQuery(hql).getResultList().get(0).toString());
	 Iterator<UserDeviceEffort> it=(Iterator<UserDeviceEffort>)entityManager.createQuery(hql).getResultList().iterator();
	 while(it.hasNext())
	 {
	     Object userEffort= it.next();
	     System.out.println("object is "+userEffort.toString());
	     //userEfforList.add(userEffort);
	 }
	 return userEfforList;
    }

}
