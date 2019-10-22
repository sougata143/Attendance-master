package com.sougata.attendance.repository.customrepository;

import java.util.List;

import com.sougata.attendance.entity.BiometricTransaction;

public interface BiometricTransactionCustomRepository {

    BiometricTransaction getBiometricTransactionById(Long id);

    void deleteBiometricTransaction(Long id);

    void updateBiometricTransaction(BiometricTransaction biometricTransaction);

    void addBiometricTransaction(BiometricTransaction biometricTransaction);

    List<BiometricTransaction> getAllBiometricTransactions();

}
