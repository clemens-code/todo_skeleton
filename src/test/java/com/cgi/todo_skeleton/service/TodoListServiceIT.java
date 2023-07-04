package com.cgi.todo_skeleton.service;

import com.cgi.todo_skeleton.model.Task;
import com.cgi.todo_skeleton.model.TodoList;
import com.cgi.todo_skeleton.repo.TaskRepository;
import com.cgi.todo_skeleton.repo.TodoListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


public class TodoListServiceIT {

    @Autowired
    private TodoListRepository todoListRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TodoListService todoListService;

    @BeforeEach
    void init() {
        // clear database to be sure no shit left over
        todoListRepository.deleteAll();
        taskRepository.deleteAll();
    }

    @Test
    void testGetTodoListById() {
        var id = 1;
        //test data
        var todoList = new TodoList(1, "IT", "IT", LocalDateTime.now());
        var taskOne = new Task(1, "Task 1 of Many", false, 1);
        var taskTwo = new Task(2, "Task 2 of Many", false, 1);
        var taskThree = new Task(3, "Task 3 of Many", true, 1);
        //save test data to the database
        todoListRepository.save(todoList);
        taskRepository.save(taskOne);
        taskRepository.save(taskTwo);
        taskRepository.save(taskThree);

        var result = todoListService.getTodoListById(id);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(todoList.getId());

    }

}
