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

import com.sougata.attendance.entity.MachineMaster;
import com.sougata.attendance.repository.MachineMasterRepository;

@Component
public class MachineMasterDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MachineMasterDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    MachineMasterRepository machineMasterRepository;

    @Transactional(readOnly = true)
    public List<MachineMaster> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<MachineMaster> machineMasterList = new ArrayList<MachineMaster>();
	for (MachineMaster machineMaster : machineMasterRepository.findAll()) {
	    LOGGER.info("MachineMaster : " + machineMaster);
	    machineMasterList.add(machineMaster);

	}
	return machineMasterList;

    }

    @Transactional(readOnly = true)
    public MachineMaster findMachineMasterByMachineCode(String machineCode) {
	return machineMasterRepository.findByMachineCode(machineCode).get(0);
    }

    @Transactional(readOnly = true)
    public MachineMaster findMachineMasterByMachineDesc(String machineDesc) {
	return machineMasterRepository.findByMachineDesc(machineDesc).get(0);
    }

    @Transactional(readOnly = true)
    public List<MachineMaster> findMachineMasterByDepartment(String department) {
	return machineMasterRepository.findByDept(department);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addMachineMaster(MachineMaster machineMaster) {

	LOGGER.info("in dao for adding machineMaster master ");
	if (null != machineMaster.getMachineCode()) {
	    LOGGER.info("size is " + machineMasterRepository.findByMachineCode(machineMaster.getMachineCode()).size());
	    if (machineMasterRepository.findByMachineCode(machineMaster.getMachineCode()).size() > 0) {
		machineMaster.setMachineCode(machineMasterRepository.findByMachineCode(machineMaster.getMachineCode())
			.get(0).getMachineCode());
	    }
	}
	machineMasterRepository.addMachineMaster(machineMaster);
	LOGGER.info("MachineMaster added successfully " + machineMaster.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteMachineMaster(String machineMasterCode) {
	machineMasterRepository.deleteMachineMaster(machineMasterCode);
	LOGGER.info("MachineMaster with code " + machineMasterCode + " deleted successfully ");
    }

}
