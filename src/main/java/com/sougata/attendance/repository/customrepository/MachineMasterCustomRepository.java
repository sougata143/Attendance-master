package com.sougata.attendance.repository.customrepository;

import java.util.List;

import com.sougata.attendance.entity.MachineMaster;

public interface MachineMasterCustomRepository {

    MachineMaster getMachineMasterByMachineCode(String machineCode);

    void deleteMachineMaster(String machineCode);

    void updateMachineMaster(MachineMaster machineMaster);

    void addMachineMaster(MachineMaster machineMaster);

    List<MachineMaster> getAllMachineMasters();

}
