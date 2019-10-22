package com.sougata.attendance.entity;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Activity.class)
public abstract class Activity_ {

	public static volatile SingularAttribute<Activity, Date> activityStartDate;
	public static volatile SingularAttribute<Activity, Date> modifiedOn;
	public static volatile SingularAttribute<Activity, String> activityName;
	public static volatile SingularAttribute<Activity, String> activityStatus;
	public static volatile SingularAttribute<Activity, Date> activityEndDate;
	public static volatile SingularAttribute<Activity, String> modifiedBy;
	public static volatile SingularAttribute<Activity, Long> id;

}

