package com.sougata.attendance.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BiometricIntegration.class)
public abstract class BiometricIntegration_ {

	public static volatile SingularAttribute<BiometricIntegration, Timestamp> inTime;
	public static volatile SingularAttribute<BiometricIntegration, Date> modifiedOn;
	public static volatile SingularAttribute<BiometricIntegration, String> createdBy;
	public static volatile SingularAttribute<BiometricIntegration, Date> inDate;
	public static volatile SingularAttribute<BiometricIntegration, Long> integrationId;
	public static volatile SingularAttribute<BiometricIntegration, String> modifiedBy;
	public static volatile SingularAttribute<BiometricIntegration, UserDeviceMap> userDeviceMap;
	public static volatile SingularAttribute<BiometricIntegration, Date> createdOn;
	public static volatile SingularAttribute<BiometricIntegration, String> userDeviceLocation;
	public static volatile SingularAttribute<BiometricIntegration, Timestamp> outTime;

}

