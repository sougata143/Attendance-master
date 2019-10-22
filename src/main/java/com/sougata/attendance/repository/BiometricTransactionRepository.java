package com.sougata.attendance.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sougata.attendance.entity.BiometricTransaction;
import com.sougata.attendance.entity.User;
import com.sougata.attendance.entity.UserDeviceMap;
import com.sougata.attendance.repository.customrepository.BiometricTransactionCustomRepository;

public interface BiometricTransactionRepository extends CrudRepository<BiometricTransaction, Long>,
	BiometricTransactionCustomRepository, JpaSpecificationExecutor<BiometricTransaction> {

    List<BiometricTransaction> findByTransactionId(Long i);

    List<BiometricTransaction> findByUserDeviceMap(UserDeviceMap userDeviceMap);

    List<BiometricTransaction> findByUserDeviceMapAndInDate(UserDeviceMap userDeviceMap, Date inDate);

    List<BiometricTransaction> findByUser(User user);

    List<BiometricTransaction> findByUserAndInDate(User user, Date inDate);

    List<BiometricTransaction> findByInDate(Date inDate);

}
