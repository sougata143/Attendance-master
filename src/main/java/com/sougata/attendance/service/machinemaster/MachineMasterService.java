package com.sougata.attendance.service.machinemaster;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sougata.attendance.dto.MachineMasterDTO;

public interface MachineMasterService {

    public ResponseEntity<MachineMasterDTO> getMachineMasterByCode(String machineMasterCode);

    public ResponseEntity<MachineMasterDTO> getMachineMasterByDesc(String machineMasterName);
    
    public ResponseEntity<List<MachineMasterDTO>> getMachineMasterByDepartment(String department);

    public ResponseEntity<MachineMasterDTO> persistMachineMaster(
	    MachineMasterDTO machineMasterDTO);

    public ResponseEntity<List<MachineMasterDTO>> populateMachineMasterList() throws Exception;

    public void destroyMachineMasterData(String machineMasterCode);


}
