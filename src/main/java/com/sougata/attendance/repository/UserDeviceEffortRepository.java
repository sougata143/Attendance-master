package com.sougata.attendance.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sougata.attendance.entity.BiometricTransaction;
import com.sougata.attendance.entity.Task;
import com.sougata.attendance.entity.User;
import com.sougata.attendance.entity.UserDeviceEffort;
import com.sougata.attendance.repository.customrepository.UserDeviceEffortCustomRepository;

public interface UserDeviceEffortRepository
	extends CrudRepository<UserDeviceEffort, Long>, UserDeviceEffortCustomRepository,JpaSpecificationExecutor<UserDeviceEffort> {

	Optional<UserDeviceEffort> findById(Long i);

    List<UserDeviceEffort> findByUser(User user);
    
    List<UserDeviceEffort> findByUserAndEffortDate(User user,Date effortdate);
    
    List<UserDeviceEffort> findByUserAndEffortDateAndTask(User user,Date effortdate,Task task);
    
    List<UserDeviceEffort> findByUserAndEffortDateAndBiometricTransaction(User user,Date effortdate,BiometricTransaction biometricTransaction);
    
    List<UserDeviceEffort> findByUserAndBiometricTransaction(User user,BiometricTransaction biometricTransaction);

}
