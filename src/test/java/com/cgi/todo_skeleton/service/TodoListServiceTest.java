package com.cgi.todo_skeleton.service;

import com.cgi.todo_skeleton.model.TodoList;
import com.cgi.todo_skeleton.repo.TodoListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TodoListServiceTest {

    private final TodoListRepository todoListRepository = mock(TodoListRepository.class);
    private final TaskService taskService = mock(TaskService.class);
       private TodoListService todoListService;
    @BeforeEach
    void init() {
        todoListService = new TodoListService(todoListRepository, taskService);
    }
    //####  Before each test Create new instance of TodoListService  ####

    @Test
    void testGetAllTodoLists() {
        //####  Create new instance of TodoList with Values  ####
        var todoList = new TodoList(1, "test", "Byrons erster Test", LocalDateTime.now());

        //#### This is what we are Mocking: when we use findAll() it returns the list of todolist ####
        when(todoListRepository.findAll())
                .thenReturn(List.of(todoList));

        var result = todoListService.getTodoLists();

        //####  Verify that we run findAll() at least once  ####
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getId()).isEqualTo(todoList.getId());

        //#### verify that we get i listed item back regardless of what it is ####
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getId()).isEqualTo(todoList.getId());
    }

    @Test
    void getTodoListsByIdTest() {
        var id = 1;
        //####  Create a list of Task lists  ####
        var todoList = new TodoList(id, "test1", "Byron's First ToDo List", LocalDateTime.now());

        //#### This is what we are Mocking: when we use findAll() it returns the list of todolist ####
        when(todoListRepository.findById(id))
                .thenReturn(Optional.of(todoList));

        var result = todoListService.getTodoListById(id);

        //####  Verify that Result isn't NUll and equal to ID  ####
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(id);
    }

}
