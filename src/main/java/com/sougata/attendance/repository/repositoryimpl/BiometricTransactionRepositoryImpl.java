package com.sougata.attendance.repository.repositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.attendance.entity.BiometricTransaction;
import com.sougata.attendance.repository.customrepository.BiometricTransactionCustomRepository;

@Transactional
@Repository
public class BiometricTransactionRepositoryImpl implements BiometricTransactionCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BiometricTransaction getBiometricTransactionById(Long transactionId) {
	return entityManager.find(BiometricTransaction.class, transactionId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<BiometricTransaction> getAllBiometricTransactions() {
	String hql = "FROM BiometricTransaction as biometricTransaction ORDER BY biometricTransaction.id";
	return (List<BiometricTransaction>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addBiometricTransaction(BiometricTransaction biometricTransaction) {
	entityManager.merge(biometricTransaction);
    }

    @Override
    public void updateBiometricTransaction(BiometricTransaction biometricTransaction) {
	BiometricTransaction BiometricTransactionItem = getBiometricTransactionById(
		biometricTransaction.getTransactionId());
    }

    @Override
    public void deleteBiometricTransaction(Long biometricTransactionId) {
	entityManager.remove(getBiometricTransactionById(biometricTransactionId));
    }

}
