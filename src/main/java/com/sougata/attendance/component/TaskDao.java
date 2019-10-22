package com.sougata.attendance.component;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sougata.attendance.entity.Task;
import com.sougata.attendance.repository.ActivityRepository;
import com.sougata.attendance.repository.TaskRepository;

@Component
public class TaskDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskDao.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    TaskRepository taskRepository;
    
    @Autowired
    ActivityRepository activityRepository;

    @Transactional(readOnly = true)
    public List<Task> findAll() throws Exception {
	LOGGER.info("DATASOURCE = " + dataSource);
	List<Task> taskList = new ArrayList<Task>();
	for (Task Task : taskRepository.findAll()) {
	    LOGGER.info("Task : " + Task);
	    taskList.add(Task);

	}
	return taskList;

    }

    @Transactional(readOnly = true)
    public Task findTaskById(Long id) {
	return taskRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public Task findTaskByTaskName(String taskName) {
	return taskRepository.findByTaskName(taskName).get(0);
    }
    
    @Transactional(readOnly = true)
    public List<Task> findTaskByActivityId(Long activityId) {
	return taskRepository.findByActivity(activityRepository.findById(activityId).get());
    }
    
    @Transactional(readOnly = true)
    public List<Task> findTaskByActivityName(String activityName) {
	return taskRepository.findByActivity(activityRepository.findByActivityName(activityName).get(0));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addTask(Task task) {

	LOGGER.info("in dao for adding task master ");
//	LOGGER.info("size is " + taskRepository.findById(task.getId()).size());
//	if (taskRepository.findById(task.getId()).size() > 0) {
//	    task.setId(taskRepository.findById(task.getId()).get(0).getId());
//	}
	task.setId(taskRepository.findById(task.getId()).get().getId());
	taskRepository.addTask(task);
	LOGGER.info("Task added successfully " + task.toString());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteTask(Long taskId) {
	taskRepository.deleteTask(taskId);
	LOGGER.info("Task with id " + taskId + " deleted successfully ");
    }

}
