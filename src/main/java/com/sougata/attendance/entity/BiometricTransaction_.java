package com.sougata.attendance.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;



@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BiometricTransaction.class)
public abstract class BiometricTransaction_ {

	public static volatile SingularAttribute<BiometricTransaction, Timestamp> lastOutTime;
	public static volatile SingularAttribute<BiometricTransaction, Date> inDate;
	public static volatile SingularAttribute<BiometricTransaction, Timestamp> totalTimeOnFloor;
	public static volatile SingularAttribute<BiometricTransaction, UserDeviceMap> userDeviceMap;
	public static volatile SingularAttribute<BiometricTransaction, Timestamp> firstInTime;
	public static volatile SingularAttribute<BiometricTransaction, User> user;
	public static volatile SingularAttribute<BiometricTransaction, Long> transactionId;
	public static volatile SingularAttribute<BiometricTransaction, String> userDeviceLocation;

}

