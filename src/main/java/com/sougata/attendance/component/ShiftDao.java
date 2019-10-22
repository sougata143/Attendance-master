package com.sougata.attendance.component;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sougata.attendance.entity.Shift;
import com.sougata.attendance.repository.ShiftRepository;

@Component
public class ShiftDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiftDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ShiftRepository shiftRepository;

    @Transactional(readOnly = true)
    public List<Shift> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<Shift> shiftList = new ArrayList<Shift>();
	for (Shift shift : shiftRepository.findAll()) {
	    LOGGER.info("Shift : " + shift);
	    shiftList.add(shift);

	}
	return shiftList;

    }

    @Transactional(readOnly = true)
    public Shift findShiftById(Long id) {
	return shiftRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public Shift findShiftByShiftName(String shiftName) {
	return shiftRepository.findByShiftName(shiftName).get(0);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addShift(Shift shift) {

	LOGGER.info("in dao for adding shift master ");
	LOGGER.info("size is " + shiftRepository.findByShiftName(shift.getShiftName()).size());
	if (shiftRepository.findByShiftName(shift.getShiftName()).size() > 0) {
	    shift.setId(shiftRepository.findByShiftName(shift.getShiftName()).get(0).getId());
	}
	shiftRepository.addShift(shift);
	LOGGER.info("Shift added successfully " + shift.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteShift(Long shiftId) {
	shiftRepository.deleteShift(shiftId);
	LOGGER.info("Shift with id " + shiftId + " deleted successfully ");
    }

}
