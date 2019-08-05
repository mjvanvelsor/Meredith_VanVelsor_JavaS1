package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {

    @Autowired
    TaskerDao taskerDao;

    @Before
    public void setUp() throws Exception {
        List<Task> taskList = taskerDao.getAllTasks();
        taskList.stream().forEach(task -> taskerDao.deleteTask(task.getId()));
    }

    @Test
    public void createGetDeleteTask() {
        Task task = new Task();
        task.setDescription("Do a thing.");
        task.setCreateDate(LocalDate.of(2019, 7, 02));
        task.setDueDate(LocalDate.of(2019, 8, 02));
        task.setCategory("Design");

        taskerDao.createTask(task);

        assertEquals(task, taskerDao.getTask(task.getId()));

        taskerDao.deleteTask(task.getId());
        assertNull(taskerDao.getTask(task.getId()));
    }

    @Test
    public void getAllTasksAndGetAllByCategory() {
        Task task = new Task();
        task.setDescription("Do a thing.");
        task.setCreateDate(LocalDate.of(2019, 7, 02));
        task.setDueDate(LocalDate.of(2019, 8, 02));
        task.setCategory("Design");

        taskerDao.createTask(task);

        Task task1 = new Task();
        task1.setDescription("Do another thing.");
        task1.setCreateDate(LocalDate.of(2019, 7, 13));
        task1.setDueDate(LocalDate.of(2019, 8, 13));
        task1.setCategory("Engineering");

        taskerDao.createTask(task1);

        List<Task> taskList = taskerDao.getAllTasks();

        assertEquals(taskList.size(), 2);

        List<Task> taskByCatList = taskerDao.getTasksByCategory("Engineering");

        //put all tasks into list
        //then compare list size to int value
        assertEquals(1,taskByCatList.size());
    }

    @Test
    public void updateTask() {
        Task task = new Task();
        task.setDescription("Do a thing.");
        task.setCreateDate(LocalDate.of(2019, 7, 02));
        task.setDueDate(LocalDate.of(2019, 8, 02));
        task.setCategory("Design");

        taskerDao.createTask(task);

        task.setDescription("Do a different thing.");
        task.setCategory("Quality Assurance");

        taskerDao.updateTask(task);

        assertEquals(task, taskerDao.getTask(task.getId()));
    }

}