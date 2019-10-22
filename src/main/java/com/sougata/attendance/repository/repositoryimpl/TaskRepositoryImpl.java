package com.sougata.attendance.repository.repositoryimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sougata.attendance.entity.Task;
import com.sougata.attendance.repository.customrepository.TaskCustomRepository;

@Transactional
@Repository
public class TaskRepositoryImpl implements TaskCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Task getTaskById(Long integrationId) {
	return entityManager.find(Task.class, integrationId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Task> getAllTasks() {
	String hql = "FROM Task as task ORDER BY task.id";
	return (List<Task>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addTask(Task task) {
	entityManager.merge(task);
    }

    @Override
    public void updateTask(Task task) {
	Task TaskItem = getTaskById(task.getId());
    }

    @Override
    public void deleteTask(Long taskId) {
	entityManager.remove(getTaskById(taskId));
    }

}
