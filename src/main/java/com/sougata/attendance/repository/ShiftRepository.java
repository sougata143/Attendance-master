package com.sougata.attendance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sougata.attendance.entity.Shift;
import com.sougata.attendance.repository.customrepository.ShiftCustomRepository;

public interface ShiftRepository extends CrudRepository<Shift, Long>, ShiftCustomRepository {

    Optional<Shift> findById(Long id);

    List<Shift> findByShiftName(String shiftName);

}
