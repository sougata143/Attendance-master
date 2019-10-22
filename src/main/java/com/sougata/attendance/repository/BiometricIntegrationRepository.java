package com.sougata.attendance.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sougata.attendance.entity.BiometricIntegration;
import com.sougata.attendance.entity.UserDeviceMap;
import com.sougata.attendance.repository.customrepository.BiometricIntegrationCustomRepository;

public interface BiometricIntegrationRepository
	extends CrudRepository<BiometricIntegration, Long>, BiometricIntegrationCustomRepository {

    List<BiometricIntegration> findByIntegrationId(Long i);

    List<BiometricIntegration> findByUserDeviceMap(UserDeviceMap userDeviceMap);

    List<BiometricIntegration> findByUserDeviceMapAndInDate(UserDeviceMap userDeviceMap, Date inDate);

}
