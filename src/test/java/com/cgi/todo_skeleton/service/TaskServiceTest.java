package com.cgi.todo_skeleton.service;


import com.cgi.todo_skeleton.model.Task;
import com.cgi.todo_skeleton.repo.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TaskServiceTest {

    private final TaskRepository taskRepository = mock(TaskRepository.class);


    private TaskService taskService;



    @BeforeEach
    void init() {
        taskService = new TaskService(taskRepository);
    }

    @Test
    void testGetAllTasks(){
        //####  Create new instance of a Task  ####
        var task = new Task(1, "testing", false );

        when(taskRepository.findAll())
                .thenReturn(List.of(task));

        var result = taskService.getTasks();

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getId()).isEqualTo(task.getId());



    }

    @Test
    void getTasksByTodoListIdTest() {
        var id = 2;

        //####  Create Tasks for the list related to same list id ####
        //####  Only need the tasks not the list they are separate Entities  ####
        var taskOne = new Task(1,"Task 1 of Many", false);
        var taskTwo = new Task(2,"Task 2 of Many", false);
        var taskThree = new Task(3,"Task 3 of Many", true);
        var taskFour = new Task(4,"Task 4 of Many", false);

        //#### This is what we are Mocking: findAllByTodoListId(id)  ####
        // ####  When we ask for all tasks it returns the following four tasks  ####
        when(taskRepository.findAllByTodoListId(id))
                .thenReturn(List.of(taskOne, taskTwo, taskThree, taskFour));

        var result = taskService.getTasksByTodoListId(id);

        //####  Verify that Result isn't Null  ####
        assertThat(result).isNotNull();

    }


}
