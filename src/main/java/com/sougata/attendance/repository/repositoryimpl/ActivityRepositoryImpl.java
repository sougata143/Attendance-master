package com.sougata.attendance.repository.repositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.attendance.entity.Activity;
import com.sougata.attendance.repository.customrepository.ActivityCustomRepository;

@Transactional
@Repository
public class ActivityRepositoryImpl implements ActivityCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Activity getActivityById(Long integrationId) {
	return entityManager.find(Activity.class, integrationId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Activity> getAllActivities() {
	String hql = "FROM Activity as activity ORDER BY activity.id";
	return (List<Activity>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addActivity(Activity activity) {
	entityManager.merge(activity);
    }

    @Override
    public void updateActivity(Activity activity) {
	Activity ActivityItem = getActivityById(activity.getId());
    }

    @Override
    public void deleteActivity(Long activityId) {
	entityManager.remove(getActivityById(activityId));
    }

}
