package com.imatia.test.taskservices.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imatia.test.taskservices.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, UUID> {
 
    Iterable<Task> findByName(String name);
}
