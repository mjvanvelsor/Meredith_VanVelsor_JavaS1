package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    TaskerDao taskerDao;
    AdServerClient client;

    @Autowired
    public TaskerServiceLayer(TaskerDao taskerDao, AdServerClient client) {
        this.taskerDao = taskerDao;
        this.client = client;
    }

    // Tasker API

    @Transactional
    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        taskViewModel.setId(taskerDao.createTask(task).getId());
        taskViewModel.setAdvertisement(client.getAd());

        return taskViewModel;
    }

    public TaskViewModel fetchTask(int id) {

        Task task = taskerDao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        tvm.setAdvertisement(client.getAd());
        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> taskList = taskerDao.getAllTasks();
        List<TaskViewModel> tvmList = new ArrayList<>();

        taskList.stream().forEach(task -> tvmList.add(buildTaskViewModel(task)));
        return tvmList;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> taskList = taskerDao.getTasksByCategory(category);
        List<TaskViewModel> tvmList = new ArrayList<>();

        taskList.stream().forEach(task -> tvmList.add(buildTaskViewModel(task)));
        return tvmList;
    }

    @Transactional
    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setId(taskViewModel.getId());
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        taskerDao.updateTask(task);
    }

    public void removeTask(int id) {
        taskerDao.deleteTask(id);
    }

    private TaskViewModel buildTaskViewModel(Task task){
        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setId(task.getId());
        taskViewModel.setDescription(task.getDescription());
        taskViewModel.setCreateDate(task.getCreateDate());
        taskViewModel.setDueDate(task.getDueDate());
        taskViewModel.setCategory(task.getCategory());
        taskViewModel.setAdvertisement(client.getAd());

        return taskViewModel;
    }
}
