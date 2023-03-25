package com.imatia.test.taskservices.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imatia.test.taskservices.controller.exceptions.TaskNotFoundException;
import com.imatia.test.taskservices.model.Task;
import com.imatia.test.taskservices.service.TaskService;

@RestController
@RequestMapping(TaskController.REQUEST_MAPPING)
public class TaskController {
    public static final String REQUEST_MAPPING = "task";

    private static final UUID DEFAULT_UUID = UUID.fromString("da75a13a-aa95-11ec-b909-0242ac120002");

    @Autowired
    private final TaskService taskService;

    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/default")
    @CrossOrigin(origins = "*")
    public Task findDefaultTask() {
        return taskService.findTaskById(DEFAULT_UUID).orElseThrow();
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(value = "/{idTask}")
    public Task getTaskById(@PathVariable UUID idTask) {
        return taskService.findTaskById(idTask).orElseThrow();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

    @PutMapping(value = "/{idTask}")
    public void updateTask(@PathVariable UUID idTask, @RequestBody Task task) {
        
		
		taskService.updateTask(idTask, task);
    }

    @DeleteMapping(value = "/{idTask}")
    public void deleteTask(@PathVariable UUID idTask) {
        taskService.deleteTask(idTask);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Task not found")
    public void exceptionHandler() {

    }
	/*Cuando se usa @CrossOrigin(origins = "*"), el asterisco indica que se permite el 
	acceso desde cualquier origen. Es importante tener en cuenta que esto puede ser un 
	riesgo de seguridad si se utiliza en un entorno de producción, ya que puede permitir 
	solicitudes desde cualquier dominio. Por lo tanto, es recomendable limitar los orígenes
	permitidos a los que se necesitan para el funcionamiento de la aplicación.*/
}
