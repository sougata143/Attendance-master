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

import com.sougata.attendance.entity.Activity;
import com.sougata.attendance.repository.ActivityRepository;

@Component
public class ActivityDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    ActivityRepository activityRepository;

    @Transactional(readOnly = true)
    public List<Activity> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<Activity> activityList = new ArrayList<Activity>();
	for (Activity activity : activityRepository.findAll()) {
	    LOGGER.info("Activity : " + activity);
	    activityList.add(activity);

	}
	return activityList;

    }

    @Transactional(readOnly = true)
    public Activity findActivityById(Long id) {
	return activityRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public Activity findActivityByActivityName(String activityName) {
	return activityRepository.findByActivityName(activityName).get(0);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addActivity(Activity activity) {

	LOGGER.info("in dao for adding activity master ");
//	LOGGER.info("size is " + activityRepository.findById(activity.getId()).size());
	activity.setId(activityRepository.findById(activity.getId()).get().getId());
	activityRepository.addActivity(activity);
	LOGGER.info("Activity added successfully " + activity.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteActivity(Long ActivityId) {
	activityRepository.deleteActivity(ActivityId);
	LOGGER.info("Activity with id " + ActivityId + " deleted successfully ");
    }

}
