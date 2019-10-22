package com.sougata.attendance.repository.customrepository;

import java.util.List;

import com.sougata.attendance.entity.BiometricIntegration;

public interface BiometricIntegrationCustomRepository {

    BiometricIntegration getBiometricIntegrationById(Long id);

    void deleteBiometricIntegration(Long id);

    void updateBiometricIntegration(BiometricIntegration biometricIntegration);

    void addBiometricIntegration(BiometricIntegration userDeviceMap);

    List<BiometricIntegration> getAllBiometricIntegrations();

}
