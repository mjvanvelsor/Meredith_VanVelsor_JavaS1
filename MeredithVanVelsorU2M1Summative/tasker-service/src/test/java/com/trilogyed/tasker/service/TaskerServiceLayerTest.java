package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskerServiceLayerTest {

    TaskerDao taskerDao;
    AdServerClient client;
    TaskerServiceLayer service;

    @Before
    public void setUp() throws Exception {
        setUpTaskerDaoMock();
        setUpAdServerClientMock();

        service = new TaskerServiceLayer(taskerDao, client);
    }

    private void setUpTaskerDaoMock(){
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);

        Task task = new Task();
        task.setId(1);
        task.setDescription("Do a thing.");
        task.setCreateDate(LocalDate.of(2019, 7, 02));
        task.setDueDate(LocalDate.of(2019, 8, 02));
        task.setCategory("Design");

        Task task1 = new Task();
        task1.setDescription("Do a thing.");
        task1.setCreateDate(LocalDate.of(2019, 7, 02));
        task1.setDueDate(LocalDate.of(2019, 8, 02));
        task1.setCategory("Design");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);

        doReturn(task).when(taskerDao).createTask(task1);
        doReturn(task).when(taskerDao).getTask(1);
        doReturn(taskList).when(taskerDao).getAllTasks();
        doReturn(taskList).when(taskerDao).getTasksByCategory("Design");
    }

    private void setUpAdServerClientMock(){
        client = mock(AdServerClient.class);

        doReturn("Ad details").when(client).getAd();
    }

    @Test
    public void retrieveAdverstisement() {

    }

    @Test
    public void newFetchFetchAllFetchByCategoryTask() {
        TaskViewModel tvm = new TaskViewModel();
//        tvm.setId(1);
        tvm.setDescription("Do a thing.");
        tvm.setCreateDate(LocalDate.of(2019, 7, 02));
        tvm.setDueDate(LocalDate.of(2019, 8, 02));
        tvm.setCategory("Design");

        tvm = service.newTask(tvm);

        TaskViewModel tvm1 = service.fetchTask(tvm.getId());
        assertEquals(tvm, tvm1);

        List<TaskViewModel> tvmList = service.fetchAllTasks();
        assertEquals(1, tvmList.size());
        assertEquals(tvm, tvmList.get(0));
        service.fetchTasksByCategory("Design");
        assertEquals(1, tvmList.size());
    }

    @Test
    public void updateTask() {
        TaskViewModel taskVM = service.fetchTask(1);
        taskVM.setDescription("Do a thing.");
        taskVM.setCreateDate(LocalDate.of(2019, 7, 02));
        taskVM.setDueDate(LocalDate.of(2019, 8, 02));
        taskVM.setCategory("Engineering");

        service.updateTask(taskVM);

        ArgumentCaptor<Task> taskArgumentCaptor = ArgumentCaptor.forClass(Task.class);
        verify(taskerDao).updateTask(taskArgumentCaptor.capture());
        assertEquals(taskVM.getCategory(), taskArgumentCaptor.getValue().getCategory());
    }

    @Test
    public void removeTask() {
        TaskViewModel taskVM = service.fetchTask(1);
        service.removeTask(1);

        ArgumentCaptor<Integer> taskCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(taskerDao).deleteTask(taskCaptor.capture());
        assertEquals(taskVM.getId(), taskCaptor.getValue().intValue());
    }
}