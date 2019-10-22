package com.sougata.attendance.repository.repositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.attendance.entity.MachineMaster;
import com.sougata.attendance.repository.customrepository.MachineMasterCustomRepository;

@Transactional
@Repository
public class MachineMasterRepositoryImpl implements MachineMasterCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public MachineMaster getMachineMasterByMachineCode(String machineMasterCode) {
	return entityManager.find(MachineMaster.class, machineMasterCode);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MachineMaster> getAllMachineMasters() {
	String hql = "FROM MachineMaster as machineMaster ORDER BY machineMaster.id";
	return (List<MachineMaster>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addMachineMaster(MachineMaster machineMaster) {
	entityManager.merge(machineMaster);
    }

    @Override
    public void updateMachineMaster(MachineMaster machineMaster) {
	MachineMaster machineMasterItem = getMachineMasterByMachineCode(machineMaster.getMachineCode());
    }

    @Override
    public void deleteMachineMaster(String machineMasterCode) {
	entityManager.remove(getMachineMasterByMachineCode(machineMasterCode));
    }

}
