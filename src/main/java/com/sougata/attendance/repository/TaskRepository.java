package com.sougata.attendance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sougata.attendance.entity.Activity;
import com.sougata.attendance.entity.Task;
import com.sougata.attendance.repository.customrepository.TaskCustomRepository;

public interface TaskRepository extends CrudRepository<Task, Long>, TaskCustomRepository {

	Optional<Task> findById(Long id);

    List<Task> findByTaskName(String taskName);
    
    List<Task> findByActivity(Activity activity);

}
