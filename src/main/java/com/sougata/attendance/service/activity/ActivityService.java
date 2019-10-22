package com.sougata.attendance.service.activity;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sougata.attendance.dto.ActivityDTO;

public interface ActivityService {

    public ResponseEntity<ActivityDTO> getActivityById(String activityId);

    public ResponseEntity<ActivityDTO> getActivityByName(String activityName);

    public ResponseEntity<ActivityDTO> persistActivity(
	    ActivityDTO activityDTO);

    public ResponseEntity<List<ActivityDTO>> populateActivityList() throws Exception;

    public void destroyActivityData(String activityId);


}
