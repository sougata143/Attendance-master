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

import com.sougata.attendance.entity.BiometricIntegration;
import com.sougata.attendance.entity.UserDeviceMap;
import com.sougata.attendance.repository.BiometricIntegrationRepository;

@Component
public class BiometricIntegrationDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BiometricIntegrationDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    BiometricIntegrationRepository biometricIntegrationRepository;

    @Transactional(readOnly = true)
    public List<BiometricIntegration> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<BiometricIntegration> biometricIntegrationList = new ArrayList<BiometricIntegration>();
	for (BiometricIntegration BiometricIntegration : biometricIntegrationRepository.findAll()) {
	    LOGGER.info("BiometricIntegration : " + BiometricIntegration);
	    biometricIntegrationList.add(BiometricIntegration);

	}
	return biometricIntegrationList;

    }

    @Transactional(readOnly = true)
    public List<BiometricIntegration> findByUserDeviceMap(UserDeviceMap userdevice) {
	for (BiometricIntegration BiometricIntegration : biometricIntegrationRepository.findByUserDeviceMap(userdevice)) {
	    LOGGER.info("BiometricIntegration : " + BiometricIntegration);
	}
	return biometricIntegrationRepository.findByUserDeviceMap(userdevice);
    }

    @Transactional(readOnly = true)
    public BiometricIntegration findBiometricIntegrationById(Long id) {
	for (BiometricIntegration BiometricIntegration : biometricIntegrationRepository.findByIntegrationId(id)) {
	    LOGGER.info("BiometricIntegration : " + BiometricIntegration);
	}
	return biometricIntegrationRepository.findByIntegrationId(id).get(0);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addBiometricIntegration(BiometricIntegration biometricIntegration) {

	LOGGER.info("in dao for mapping biometric integration ");
	/*LOGGER.info("size is " + biometricIntegrationRepository.findByUserDeviceMapAndInDate(biometricIntegration.getUserDeviceMap(),biometricIntegration.getInDate()).size());
	if (biometricIntegrationRepository.findByUserDeviceMapAndInDate(biometricIntegration.getUserDeviceMap(),biometricIntegration.getInDate()).size() > 0) {
	    biometricIntegration.setIntegrationId(biometricIntegrationRepository.findByUserDeviceMapAndInDate(biometricIntegration.getUserDeviceMap(),biometricIntegration.getInDate()).get(0).getIntegrationId());
	}*/
	biometricIntegrationRepository.addBiometricIntegration(biometricIntegration);
	LOGGER.info("BiometricIntegration added successfully " + biometricIntegration.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteBiometricIntegration(Long BiometricIntegrationId) {
	biometricIntegrationRepository.deleteBiometricIntegration(BiometricIntegrationId);
	LOGGER.info("BiometricIntegration with id " + BiometricIntegrationId + " deleted successfully ");
    }

}
