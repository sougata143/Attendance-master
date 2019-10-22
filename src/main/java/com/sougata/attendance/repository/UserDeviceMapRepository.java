package com.sougata.attendance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sougata.attendance.entity.User;
import com.sougata.attendance.entity.UserDeviceMap;
import com.sougata.attendance.repository.customrepository.UserDeviceMapCustomRepository;

public interface UserDeviceMapRepository extends CrudRepository<UserDeviceMap, Long>, UserDeviceMapCustomRepository {

	Optional<UserDeviceMap> findById(Long i);

    List<UserDeviceMap> findByUser(User user);

    List<UserDeviceMap> findByDeviceId(Long deviceId);

}
