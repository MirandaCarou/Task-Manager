package com.imatia.test.taskservices.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imatia.test.taskservices.model.Task;
import com.imatia.test.taskservices.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return (List<Task>) taskRepository.findAll();
    }
	
	@Override
    public Optional<Task> findTaskById(UUID idTask) {
        return taskRepository.findById(idTask);
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(UUID idTask, Task task) {
		Task taskToUpdate = findTaskById(idTask).orElseThrow();
		taskToUpdate.setIdTask(idTask);
		taskToUpdate.setName(task.getName());
		taskToUpdate.setCreationDate(task.getCreationDate());
		taskToUpdate.setDeadLine(task.getDeadLine());
		taskToUpdate.setDescription(task.getDescription());
		taskToUpdate.setFavorite(task.getFavorite());
		taskRepository.save(taskToUpdate);
    }

    public void deleteTask(UUID idTask) {
        taskRepository.deleteById(idTask);
    }


}
