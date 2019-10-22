package com.sougata.attendance.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TASK_TYPE")
public class Task {

    @Id
    @Column(name = "TASK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "TASK_NAME")
    private String taskName;

    @Column(name = "MOD_BY")
    private String modifiedBy;

    @Column(name = "MOD_ON")
    private Date modifiedOn;
    
    @ManyToOne(cascade = { CascadeType.ALL },fetch= FetchType.EAGER)
    @JoinColumn(name="ACTIVITY_ID")
    private Activity activity;

    public Task() {
	super();
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getModifiedBy() {
	return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
    }

    public Date getModifiedOn() {
	return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
	this.modifiedOn = modifiedOn;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
	return "Task [id=" + id + ", taskName=" + taskName + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn
		+ ", activity=" + activity + "]";
    }



    
}
