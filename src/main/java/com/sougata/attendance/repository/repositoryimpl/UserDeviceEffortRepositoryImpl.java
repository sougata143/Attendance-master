package com.sougata.attendance.repository.repositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.attendance.entity.UserDeviceEffort;
import com.sougata.attendance.repository.customrepository.UserDeviceEffortCustomRepository;

@Transactional
@Repository
public class UserDeviceEffortRepositoryImpl implements UserDeviceEffortCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserDeviceEffort getUserDeviceEffortById(Long userDeviceEffortId) {
	return entityManager.find(UserDeviceEffort.class, userDeviceEffortId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserDeviceEffort> getAllUserDeviceEfforts() {
	String hql = "FROM UserDeviceEffort as userDeviceEffort ORDER BY userDeviceEffort.id";
	return (List<UserDeviceEffort>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addUserDeviceEffort(UserDeviceEffort UserDeviceEffort) {
	entityManager.merge(UserDeviceEffort);
    }

    @Override
    public void updateUserDeviceEffort(UserDeviceEffort UserDeviceEffort) {
	UserDeviceEffort UserDeviceEffortItem = getUserDeviceEffortById(UserDeviceEffort.getId());
    }

    @Override
    public void deleteUserDeviceEffort(Long UserDeviceEffortId) {
	entityManager.remove(getUserDeviceEffortById(UserDeviceEffortId));
    }

}
