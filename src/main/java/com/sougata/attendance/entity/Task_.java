package com.sougata.attendance.entity;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Task.class)
public abstract class Task_ {

	public static volatile SingularAttribute<Task, Date> modifiedOn;
	public static volatile SingularAttribute<Task, Activity> activity;
	public static volatile SingularAttribute<Task, String> taskName;
	public static volatile SingularAttribute<Task, String> modifiedBy;
	public static volatile SingularAttribute<Task, Long> id;

}

