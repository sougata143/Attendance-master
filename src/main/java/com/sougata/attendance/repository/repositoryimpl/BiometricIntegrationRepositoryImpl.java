package com.sougata.attendance.repository.repositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.attendance.entity.BiometricIntegration;
import com.sougata.attendance.repository.customrepository.BiometricIntegrationCustomRepository;

@Transactional
@Repository
public class BiometricIntegrationRepositoryImpl implements BiometricIntegrationCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BiometricIntegration getBiometricIntegrationById(Long integrationId) {
	return entityManager.find(BiometricIntegration.class, integrationId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BiometricIntegration> getAllBiometricIntegrations() {
	String hql = "FROM BiometricIntegration as biometricIntegration ORDER BY biometricIntegration.id";
	return (List<BiometricIntegration>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addBiometricIntegration(BiometricIntegration biometricIntegration) {
	entityManager.merge(biometricIntegration);
    }

    @Override
    public void updateBiometricIntegration(BiometricIntegration biometricIntegration) {
	BiometricIntegration BiometricIntegrationItem = getBiometricIntegrationById(
		biometricIntegration.getIntegrationId());
    }

    @Override
    public void deleteBiometricIntegration(Long biometricIntegrationId) {
	entityManager.remove(getBiometricIntegrationById(biometricIntegrationId));
    }

}
