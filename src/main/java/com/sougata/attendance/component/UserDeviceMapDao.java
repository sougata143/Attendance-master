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

import com.sougata.attendance.entity.User;
import com.sougata.attendance.entity.UserDeviceMap;
import com.sougata.attendance.repository.UserDeviceMapRepository;

@Component
public class UserDeviceMapDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDeviceMapDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    UserDeviceMapRepository userDeviceMapRepository;

    @Transactional(readOnly = true)
    public List<UserDeviceMap> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<UserDeviceMap> UserDeviceMapList = new ArrayList<UserDeviceMap>();
	for (UserDeviceMap UserDeviceMap : userDeviceMapRepository.findAll()) {
	    LOGGER.info("UserDeviceMap : " + UserDeviceMap);
	    UserDeviceMapList.add(UserDeviceMap);

	}
	return UserDeviceMapList;

    }

    @Transactional(readOnly = true)
    public List<UserDeviceMap> findByUser(User user) {
	for (UserDeviceMap UserDeviceMap : userDeviceMapRepository.findByUser(user)) {
	    LOGGER.info("UserDeviceMap : " + UserDeviceMap);
	}
	return userDeviceMapRepository.findByUser(user);
    }
    
    @Transactional(readOnly = true)
    public UserDeviceMap findByDeviceId(Long userDevicId) {
	for (UserDeviceMap UserDeviceMap : userDeviceMapRepository.findByDeviceId(userDevicId)) {
	    LOGGER.info("UserDeviceMap : " + UserDeviceMap);
	}
	return userDeviceMapRepository.findByDeviceId(userDevicId).get(0);
    }

    @Transactional(readOnly = true)
    public UserDeviceMap findUserDeviceMapById(Long id) {
//	for (UserDeviceMap UserDeviceMap : userDeviceMapRepository.findById(id)) {
//	    LOGGER.info("UserDeviceMap : " + UserDeviceMap);
//	}
	return userDeviceMapRepository.findById(id).get();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addUserDeviceMap(UserDeviceMap userDeviceMap) {

	LOGGER.info("in dao for mapping user device map");
	LOGGER.info("size is " + userDeviceMapRepository.findByUser(userDeviceMap.getUser()).size());
	if (userDeviceMapRepository.findByUser(userDeviceMap.getUser()).size() > 0) {
	    userDeviceMap.setId(userDeviceMapRepository.findByUser(userDeviceMap.getUser()).get(0).getId());
	}
	userDeviceMapRepository.addUserDeviceMap(userDeviceMap);
	LOGGER.info("UserDeviceMap added successfully " + userDeviceMap.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserDeviceMap(Long UserDeviceMapId) {
	userDeviceMapRepository.deleteUserDeviceMap(UserDeviceMapId);
	LOGGER.info("UserDeviceMap with id " + UserDeviceMapId + " deleted successfully ");
    }

}
