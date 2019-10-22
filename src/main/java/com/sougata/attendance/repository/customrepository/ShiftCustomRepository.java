package com.sougata.attendance.repository.customrepository;

import java.util.List;

import com.sougata.attendance.entity.Shift;

public interface ShiftCustomRepository {

    Shift getShiftById(Long id);

    void deleteShift(Long id);

    void updateShift(Shift shift);

    void addShift(Shift shift);

    List<Shift> getAllShifts();

}
