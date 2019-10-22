package com.sougata.attendance.repository.customrepository;

import java.util.List;

import com.sougata.attendance.entity.UserDeviceMap;

public interface UserDeviceMapCustomRepository {

    UserDeviceMap getUserDeviceMapById(Long id);

    void deleteUserDeviceMap(Long id);

    void updateUserDeviceMap(UserDeviceMap userDeviceMap);

    void addUserDeviceMap(UserDeviceMap userDeviceMap);

    List<UserDeviceMap> getAllUserDeviceMaps();

}
