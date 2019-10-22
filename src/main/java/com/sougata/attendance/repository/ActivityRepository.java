package com.sougata.attendance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sougata.attendance.entity.Activity;
import com.sougata.attendance.repository.customrepository.ActivityCustomRepository;

public interface ActivityRepository extends CrudRepository<Activity, Long>, ActivityCustomRepository {

    Optional<Activity> findById(Long id);

    List<Activity> findByActivityName(String activityName);

}
