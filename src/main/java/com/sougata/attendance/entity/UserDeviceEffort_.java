package com.sougata.attendance.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserDeviceEffort.class)
public abstract class UserDeviceEffort_ {

	public static volatile SingularAttribute<UserDeviceEffort, Timestamp> timeInCampus;
	public static volatile SingularAttribute<UserDeviceEffort, Activity> activity;
	public static volatile SingularAttribute<UserDeviceEffort, BiometricTransaction> biometricTransaction;
	public static volatile SingularAttribute<UserDeviceEffort, String> totalEffort;
	public static volatile SingularAttribute<UserDeviceEffort, Date> effortDate;
	public static volatile SingularAttribute<UserDeviceEffort, Timestamp> timeOutsideFloor;
	public static volatile SingularAttribute<UserDeviceEffort, Date> modifiedOn;
	public static volatile SingularAttribute<UserDeviceEffort, Task> task;
	public static volatile SingularAttribute<UserDeviceEffort, String> actualEffortPerTask;
	public static volatile SingularAttribute<UserDeviceEffort, Timestamp> timeInFloor;
	public static volatile SingularAttribute<UserDeviceEffort, String> modifiedBy;
	public static volatile SingularAttribute<UserDeviceEffort, Long> id;
	public static volatile SingularAttribute<UserDeviceEffort, User> user;

}

