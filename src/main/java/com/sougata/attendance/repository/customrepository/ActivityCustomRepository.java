package com.sougata.attendance.repository.customrepository;

import java.util.List;

import com.sougata.attendance.entity.Activity;

public interface ActivityCustomRepository {

    Activity getActivityById(Long id);

    void deleteActivity(Long id);

    void updateActivity(Activity activity);

    void addActivity(Activity activity);

    List<Activity> getAllActivities();

}
