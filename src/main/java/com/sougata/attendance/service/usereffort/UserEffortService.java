package com.sougata.attendance.service.usereffort;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sougata.attendance.dto.UserDeviceEffortDTO;

public interface UserEffortService {

    public ResponseEntity<List<UserDeviceEffortDTO>> getEffortByEffortId(String effortId);

    public ResponseEntity<List<UserDeviceEffortDTO>> getEffortByUserId(String userId);

    public ResponseEntity<List<UserDeviceEffortDTO>> getEffortByUserName(String userName);

    public ResponseEntity<List<UserDeviceEffortDTO>> getEffortByUserIdAndEffortDate(String userId, String effortDate);

    public ResponseEntity<List<UserDeviceEffortDTO>> getEffortByUserNameAndEffortDate(String userName,
	    String effortDate);

    public ResponseEntity<UserDeviceEffortDTO> persistUserEffort(UserDeviceEffortDTO userEffortDTO);

    public void destroyEffort(String effortId);

    public ResponseEntity<UserDeviceEffortDTO> getEffortByUserIdAndParticularTaskAndParticularDate(String userId,
	    String taskId, String effortDate);

    public ResponseEntity<UserDeviceEffortDTO> getEffortByUserIdAndParticularActivityAndParticularDate(String userId,
	    String activityId, String effortDate);

}
