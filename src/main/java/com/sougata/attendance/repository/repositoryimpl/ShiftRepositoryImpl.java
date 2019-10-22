package com.sougata.attendance.repository.repositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.attendance.entity.Shift;
import com.sougata.attendance.repository.customrepository.ShiftCustomRepository;

@Transactional
@Repository
public class ShiftRepositoryImpl implements ShiftCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Shift getShiftById(Long shiftId) {
	return entityManager.find(Shift.class, shiftId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Shift> getAllShifts() {
	String hql = "FROM Shift as shift ORDER BY shift.id";
	return (List<Shift>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addShift(Shift shift) {
	entityManager.merge(shift);
    }

    @Override
    public void updateShift(Shift shift) {
	Shift shiftItem = getShiftById(shift.getId());
    }

    @Override
    public void deleteShift(Long shiftId) {
	entityManager.remove(getShiftById(shiftId));
    }

}
