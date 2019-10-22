package com.sougata.attendance.entity;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DeviceAttendance.class)
public abstract class DeviceAttendance_ {

	public static volatile SingularAttribute<DeviceAttendance, String> inTime;
	public static volatile SingularAttribute<DeviceAttendance, Long> id;
	public static volatile SingularAttribute<DeviceAttendance, User> user;
	public static volatile SingularAttribute<DeviceAttendance, Date> attendanceDate;
	public static volatile SingularAttribute<DeviceAttendance, String> outTime;

}

