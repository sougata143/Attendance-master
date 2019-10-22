package com.sougata.attendance.service.biometrictransaction;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sougata.attendance.dto.BiometricTransactionDTO;

public interface BiometricTransactionService {

    public ResponseEntity<List<BiometricTransactionDTO>> getAttendanceByTransactionId(String transactionId);

    public ResponseEntity<List<BiometricTransactionDTO>> getAttendanceByUserId(String userId);

    public ResponseEntity<List<BiometricTransactionDTO>> getAttendanceByUserName(String userName);

    public ResponseEntity<List<BiometricTransactionDTO>> getAttendanceByUserDeviceId(String userDeviceId);

    public ResponseEntity<List<BiometricTransactionDTO>> getAttendanceByAttendanceDate(String attendanceDate);

    public ResponseEntity<BiometricTransactionDTO> getAttendanceByUserIdAndAttendanceDate(String userId,
	    String attendanceDate);

    public ResponseEntity<BiometricTransactionDTO> getAttendanceByUserNameAndAttendanceDate(String userName,
	    String attendanceDate);

    public ResponseEntity<BiometricTransactionDTO> persistBiometricTransaction(
	    BiometricTransactionDTO biometricTransactionDTO);

    public List<BiometricTransactionDTO> populateAttendanceList() throws Exception;

    public void destroyAttendanceData(String transactionId);

    public ResponseEntity<List<BiometricTransactionDTO>> getAttendanceByUserIdAndAttendanceDateRange(String userId,
	    String startAttendanceDate, String endAttendanceDate);

}
