package com.sougata.attendance.component;

import static org.apache.commons.lang3.time.DateUtils.ceiling;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sougata.attendance.entity.BiometricTransaction;
import com.sougata.attendance.entity.User;
import com.sougata.attendance.entity.UserDeviceMap;
import com.sougata.attendance.repository.BiometricTransactionRepository;
import com.sougata.attendance.repository.BiometricTransactionSpecifications;

@Component
public class BiometricTransactionDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BiometricTransactionDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    BiometricTransactionRepository biometricTransactionRepository;

    @Transactional(readOnly = true)
    public List<BiometricTransaction> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<BiometricTransaction> biometricTransactionList = new ArrayList<BiometricTransaction>();
	for (BiometricTransaction biometricTransaction : biometricTransactionRepository.findAll()) {
	    LOGGER.info("BiometricTransaction : " + biometricTransaction);
	    biometricTransactionList.add(biometricTransaction);

	}
	return biometricTransactionList;

    }

    @Transactional(readOnly = true)
    public List<BiometricTransaction> findByUser(User user) {
	for (BiometricTransaction BiometricTransaction : biometricTransactionRepository.findByUser(user)) {
	    LOGGER.info("BiometricTransaction : " + BiometricTransaction);
	}
	return biometricTransactionRepository.findByUser(user);
    }
    
    @Transactional(readOnly = true)
    public List<BiometricTransaction> findByInDate(Date inDate) {
	return biometricTransactionRepository.findByInDate(inDate);
    }

    @Transactional(readOnly = true)
    public List<BiometricTransaction> findBiometricTransactionById(Long id) {
	return biometricTransactionRepository.findByTransactionId(id);
    }
    
    @Transactional(readOnly = true)
    public List<BiometricTransaction> findBiometricTransactionByUserDevice(UserDeviceMap userDeviceMap) {
	return biometricTransactionRepository.findByUserDeviceMap(userDeviceMap);
    }
    
    @Transactional(readOnly = true)
    public List<BiometricTransaction> findBiometricTransactionByUserDeviceAndInDate(UserDeviceMap userDeviceMap,Date inDate) {
	return biometricTransactionRepository.findByUserDeviceMapAndInDate(userDeviceMap, inDate);
    }
    
    @Transactional(readOnly = true)
    public BiometricTransaction findBiometricTransactionByUserAndInDate(User user,Date inDate) {
	java.util.Date fromDate = new java.util.Date();
	Date toDate = new Date(ceiling(inDate, Calendar.DAY_OF_MONTH).getTime() - 1);
	java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
	java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
	return biometricTransactionRepository.findAll(BiometricTransactionSpecifications.forParticularUserAndDateIgnoringTime(user, sqlFromDate, sqlToDate)).get(0);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addBiometricTransaction(BiometricTransaction biometricTransaction) {

	LOGGER.info("in dao for mapping user device effort");
	LOGGER.info("size is " + biometricTransactionRepository.findByUserAndInDate(biometricTransaction.getUser(),biometricTransaction.getInDate()).size());
	if (biometricTransactionRepository.findByUserAndInDate(biometricTransaction.getUser(),biometricTransaction.getInDate()).size() > 0) {
	    biometricTransaction.setTransactionId(biometricTransactionRepository.findByUserAndInDate(biometricTransaction.getUser(),biometricTransaction.getInDate()).get(0).getTransactionId());
	}
	biometricTransactionRepository.addBiometricTransaction(biometricTransaction);
	LOGGER.info("BiometricTransaction added successfully " + biometricTransaction.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteBiometricTransaction(Long biometricTransactionId) {
	biometricTransactionRepository.deleteBiometricTransaction(biometricTransactionId);
	LOGGER.info("BiometricTransaction with id " + biometricTransactionId + " deleted successfully ");
    }
    
    
    @Transactional(readOnly = true)
    public List<BiometricTransaction> findBiometricTransactionByUserAndDateRange(User user,Date startDate,Date endDate) {
//	java.util.Date fromDate = truncate(startDate, Calendar.DAY_OF_MONTH);
    	java.util.Date fromDate = new java.util.Date();
	Date toDate = new Date(ceiling(endDate, Calendar.DAY_OF_MONTH).getTime() - 1);
	java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
	java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
	return biometricTransactionRepository.findAll(BiometricTransactionSpecifications.forUserAndDateRange(user, sqlFromDate, sqlToDate),new Sort(Direction.ASC,"inDate"));
    }
    
    @Transactional(readOnly = true)
    public List<BiometricTransaction> findBiometricTransactionByParticularDate(Date startDate) {
//	java.util.Date fromDate = truncate(startDate, Calendar.DAY_OF_MONTH);
    	java.util.Date fromDate = new java.util.Date();
	Date toDate = new Date(ceiling(startDate, Calendar.DAY_OF_MONTH).getTime() - 1);
	java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
	java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
	return biometricTransactionRepository.findAll(BiometricTransactionSpecifications.forParticularDateIgnoringTime(sqlFromDate,sqlToDate));
    }

}
