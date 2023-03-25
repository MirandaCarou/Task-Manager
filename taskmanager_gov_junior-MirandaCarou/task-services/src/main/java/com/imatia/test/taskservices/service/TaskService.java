package com.imatia.test.taskservices.service;

import java.util.Optional;
import java.util.UUID;
import java.util.List;
import com.imatia.test.taskservices.model.Task;


public interface TaskService {

	Optional<Task> findTaskById(UUID uuid);
	
	List<Task> getAllTasks();

    void addTask(Task task);

    void deleteTask(UUID idTask);

    void updateTask(UUID idTask, Task task);

}
