package com.sougata.attendance.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sougata.attendance.entity.MachineMaster;
import com.sougata.attendance.repository.customrepository.MachineMasterCustomRepository;

public interface MachineMasterRepository extends CrudRepository<MachineMaster, String>, MachineMasterCustomRepository {

    List<MachineMaster> findByMachineCode(String machineCode);

    List<MachineMaster> findByMachineDesc(String machineDesc);
    
    List<MachineMaster> findByDept(String department);

}
