package com.sougata.attendance.component;

import static org.apache.commons.lang3.time.DateUtils.ceiling;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sougata.attendance.entity.Activity;
import com.sougata.attendance.entity.BiometricTransaction;
import com.sougata.attendance.entity.Task;
import com.sougata.attendance.entity.User;
import com.sougata.attendance.entity.UserDeviceEffort;
import com.sougata.attendance.repository.UserDeviceEffortRepository;
import com.sougata.attendance.repository.UserEffortSpecifications;

@Component
public class UserDeviceEffortDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDeviceEffortDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    UserDeviceEffortRepository userDeviceEffortRepository;

    @Transactional(readOnly = true)
    public List<UserDeviceEffort> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<UserDeviceEffort> UserDeviceEffortList = new ArrayList<UserDeviceEffort>();
	for (UserDeviceEffort UserDeviceEffort : userDeviceEffortRepository.findAll()) {
	    LOGGER.info("UserDeviceEffort : " + UserDeviceEffort);
	    UserDeviceEffortList.add(UserDeviceEffort);

	}
	return UserDeviceEffortList;

    }

    @Transactional(readOnly = true)
    public List<UserDeviceEffort> findByUser(User user) {
	for (UserDeviceEffort UserDeviceEffort : userDeviceEffortRepository.findByUser(user)) {
	    LOGGER.info("UserDeviceEffort : " + UserDeviceEffort);
	}
	return userDeviceEffortRepository.findByUser(user);
    }
    
    @Transactional(readOnly = true)
    public List<UserDeviceEffort> findByEffortByUserAndBiometric(User user,BiometricTransaction biometricTransaction) {
	for (UserDeviceEffort UserDeviceEffort : userDeviceEffortRepository.findByUserAndBiometricTransaction(user, biometricTransaction)) {
	    LOGGER.info("UserDeviceEffort : " + UserDeviceEffort);
	}
	return userDeviceEffortRepository.findByUser(user);
    }

    @Transactional(readOnly = true)
    public Optional<UserDeviceEffort> findUserDeviceEffortById(Long id) {
	return userDeviceEffortRepository.findById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addUserDeviceEffort(UserDeviceEffort userDeviceEffort) {

	LOGGER.info("in dao for mapping user device effort");
	LOGGER.info("size is " + userDeviceEffortRepository.findByUserAndEffortDateAndTask(userDeviceEffort.getUser(),userDeviceEffort.getEffortDate(),userDeviceEffort.getTask()).size());
	if (userDeviceEffortRepository.findByUserAndEffortDateAndTask(userDeviceEffort.getUser(),userDeviceEffort.getEffortDate(),userDeviceEffort.getTask()).size() > 0) {
	    userDeviceEffort.setId(userDeviceEffortRepository.findByUserAndEffortDateAndTask(userDeviceEffort.getUser(),userDeviceEffort.getEffortDate(),userDeviceEffort.getTask()).get(0).getId());
	}
	userDeviceEffortRepository.addUserDeviceEffort(userDeviceEffort);
	LOGGER.info("UserDeviceEffort added successfully " + userDeviceEffort.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserDeviceEffort(Long UserDeviceEffortId) {
	userDeviceEffortRepository.deleteUserDeviceEffort(UserDeviceEffortId);
	LOGGER.info("UserDeviceEffort with id " + UserDeviceEffortId + " deleted successfully ");
    }
    
    @Transactional(readOnly = true)
    public List<UserDeviceEffort> findEffortForUserAndInDate(User user,Date inDate) {
//	java.util.Date fromDate = truncate(inDate, Calendar.DAY_OF_MONTH);
    	java.util.Date fromDate = new java.util.Date();
	Date toDate = new Date(ceiling(inDate, Calendar.DAY_OF_MONTH).getTime() - 1);
	java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
	java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
	return userDeviceEffortRepository.findAll(UserEffortSpecifications.forParticularUserAndDateIgnoringTime(user, sqlFromDate, sqlToDate));
    }
    
    @Transactional(readOnly = true)
    public UserDeviceEffort findEffortForUserAndTaskAndInDate(User user,Task task,Date inDate) {
//	java.util.Date fromDate = truncate(inDate, Calendar.DAY_OF_MONTH);
    	java.util.Date fromDate = new java.util.Date();
	Date toDate = new Date(ceiling(inDate, Calendar.DAY_OF_MONTH).getTime() - 1);
	java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
	java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
	return userDeviceEffortRepository.findAll(UserEffortSpecifications.forUserAndParticularTaskAndDateIgnoringTime(user,task, sqlFromDate, sqlToDate)).get(0);
    }
    
    @Transactional(readOnly = true)
    public UserDeviceEffort findEffortForUserAndActivityAndInDate(User user,Activity activity,Date inDate) {
//	java.util.Date fromDate = truncate(inDate, Calendar.DAY_OF_MONTH);
    	java.util.Date fromDate = new java.util.Date();
	Date toDate = new Date(ceiling(inDate, Calendar.DAY_OF_MONTH).getTime() - 1);
	java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
	java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
	return userDeviceEffortRepository.findAll(UserEffortSpecifications.forUserAndParticularActivityAndDateIgnoringTime(user,activity, sqlFromDate, sqlToDate)).get(0);
    }
    
    @Transactional(readOnly = true)
    public List<UserDeviceEffort> findEffortByUserAndDateRange(User user,Date startDate,Date endDate) {
//	java.util.Date fromDate = truncate(startDate, Calendar.DAY_OF_MONTH);
    	java.util.Date fromDate = new java.util.Date();
	Date toDate = new Date(ceiling(endDate, Calendar.DAY_OF_MONTH).getTime() - 1);
	java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
	java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
	return userDeviceEffortRepository.findAll(UserEffortSpecifications.forUserAndDateRange(user, sqlFromDate, sqlToDate),new Sort(Direction.ASC,"effortDate"));
    }
    
    @Transactional(readOnly = true)
    public List<UserDeviceEffort> findUserEffortByParticularDate(Date startDate) {
//	java.util.Date fromDate = truncate(startDate, Calendar.DAY_OF_MONTH);
    	java.util.Date fromDate = new java.util.Date();
	Date toDate = new Date(ceiling(startDate, Calendar.DAY_OF_MONTH).getTime() - 1);
	java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
	java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
	return userDeviceEffortRepository.findAll(UserEffortSpecifications.forParticularDateIgnoringTime(sqlFromDate,sqlToDate));
    }

}
