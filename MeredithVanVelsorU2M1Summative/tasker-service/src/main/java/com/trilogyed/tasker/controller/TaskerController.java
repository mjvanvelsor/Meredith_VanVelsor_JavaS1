package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.exception.NotFoundException;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController // lets Spring know this is a Rest Controller
@RefreshScope   // lets Spring get new status without having to reload or refresh
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TaskViewModel createTask(@RequestBody @Valid TaskViewModel taskViewModel) {
        return service.newTask(taskViewModel);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TaskViewModel getTask(@PathVariable("id") int id) {
        TaskViewModel taskViewModel = service.fetchTask(id);
        if (taskViewModel == null)
            throw new NotFoundException("Task could not be retrieved for given id: " + id);
        return taskViewModel;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> getAllTasks() {
        List<TaskViewModel> taskList = service.fetchAllTasks();
        if (taskList == null)
            throw new NotFoundException("Tasks could not be retrieved.");
        return taskList;
    }

    @RequestMapping(value = "/tasks/category/{category}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> findTasksByCategory(@PathVariable("category") String category) {
        List<TaskViewModel> taskListByCat = service.fetchTasksByCategory(category);
        if (taskListByCat == null)
            throw new NotFoundException("Tasks could not be retrieved for: " + category);
        return taskListByCat;
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateTask(@PathVariable("id") int id,
                              @RequestBody @Valid TaskViewModel taskViewModel) {
        if (taskViewModel.getId() == 0)
            taskViewModel.setId(id);
        if (id != taskViewModel.getId()) {
            throw new IllegalArgumentException(
                    "Task ID on path must match the ID in the Task object."
            );
        }
        service.updateTask(taskViewModel);
    }

    @RequestMapping(value = "/tasks{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable(name = "id") int id) {
        service.removeTask(id);
    }


}
