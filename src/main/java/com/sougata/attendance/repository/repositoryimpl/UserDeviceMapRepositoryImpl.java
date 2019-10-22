package com.sougata.attendance.repository.repositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.attendance.entity.UserDeviceMap;
import com.sougata.attendance.repository.customrepository.UserDeviceMapCustomRepository;

@Transactional
@Repository
public class UserDeviceMapRepositoryImpl implements UserDeviceMapCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserDeviceMap getUserDeviceMapById(Long userDeviceMapId) {
	return entityManager.find(UserDeviceMap.class, userDeviceMapId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserDeviceMap> getAllUserDeviceMaps() {
	String hql = "FROM UserDeviceMap as userDeviceMap ORDER BY userDeviceMap.id";
	return (List<UserDeviceMap>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addUserDeviceMap(UserDeviceMap UserDeviceMap) {
	entityManager.merge(UserDeviceMap);
    }

    @Override
    public void updateUserDeviceMap(UserDeviceMap UserDeviceMap) {
	UserDeviceMap UserDeviceMapItem = getUserDeviceMapById(UserDeviceMap.getId());
    }

    @Override
    public void deleteUserDeviceMap(Long UserDeviceMapId) {
	entityManager.remove(getUserDeviceMapById(UserDeviceMapId));
    }

}
