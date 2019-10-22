package com.sougata.attendance.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserDeviceMap.class)
public abstract class UserDeviceMap_ {

	public static volatile SingularAttribute<UserDeviceMap, Date> modifiedOn;
	public static volatile SingularAttribute<UserDeviceMap, String> createdBy;
	public static volatile SingularAttribute<UserDeviceMap, String> modifiedBy;
	public static volatile SingularAttribute<UserDeviceMap, Long> id;
	public static volatile SingularAttribute<UserDeviceMap, User> user;
	public static volatile SingularAttribute<UserDeviceMap, Long> deviceId;
	public static volatile SingularAttribute<UserDeviceMap, Date> createdOn;

}

