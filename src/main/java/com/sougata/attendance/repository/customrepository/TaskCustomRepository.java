package com.sougata.attendance.repository.customrepository;

import java.util.List;

import com.sougata.attendance.entity.Task;

public interface TaskCustomRepository {

    Task getTaskById(Long id);

    void deleteTask(Long id);

    void updateTask(Task task);

    void addTask(Task task);

    List<Task> getAllTasks();

}
