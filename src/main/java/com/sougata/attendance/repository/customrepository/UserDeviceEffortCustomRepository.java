package com.sougata.attendance.repository.customrepository;

import java.util.List;

import com.sougata.attendance.entity.UserDeviceEffort;

public interface UserDeviceEffortCustomRepository {

    UserDeviceEffort getUserDeviceEffortById(Long effortId);

    void deleteUserDeviceEffort(Long effortId);

    void updateUserDeviceEffort(UserDeviceEffort userDeviceEffort);

    void addUserDeviceEffort(UserDeviceEffort userDeviceEffort);

    List<UserDeviceEffort> getAllUserDeviceEfforts();

}
