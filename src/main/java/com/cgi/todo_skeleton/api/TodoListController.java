package com.cgi.todo_skeleton.api;

import com.cgi.todo_skeleton.model.TodoList;
import com.cgi.todo_skeleton.service.TaskService;
import com.cgi.todo_skeleton.service.TodoListService;
import com.cgi.todo_skeleton.view.TodoListView;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todoList") //  ####  http://localhost:8080/todolist  ####
public class TodoListController {

    private final TodoListService todoListService;
    private final TaskService taskService;

    TodoListController(TodoListService todoListService, TaskService taskService){
        this.todoListService = todoListService;
        this.taskService = taskService;
    }

    //#### Just A Simple Test Message :   http://localhost:8080/todolist/greeting  ####
    @GetMapping("/greeting")
    public ResponseEntity<String> greet() {
        return ResponseEntity.ok("Hi This is an API !");
    }

    //####  GET  All Lists http://localhost:8080/todolist/  ###//
    @GetMapping("/")
    public List<TodoList> getAllTodoList() {
        return todoListService.getTodoLists();
    }

    //####  GET  List by id ###//
    @GetMapping("/{id}")
    public TodoListView findTodoListById(@PathVariable int id) {
        return todoListService.getTodoListById(id);
    }

    //####  POST  Add New List ###//
    @PostMapping("/")
    public TodoList addTodoList(@RequestBody TodoList todoList) {
        return todoListService.saveTodoList(todoList);
    }

    //#### DELETE To Do List By ID ####
    @DeleteMapping("/{id}")
    public String deleteTodoList(@PathVariable int id) {
        return todoListService.deleteTodoList(id);
    }

    //#### DELETE Task By ID ####
    @DeleteMapping("/task/{id}")
    public String deleteTask(@PathVariable int id) {
        return taskService.deleteTask(id);
    }
    //
    /**
     * TODO make a controller with following features
     *  - get an overview of TodoLists without the tasks
     *  - get a specific todolist with all tasks attached
     *  - add a new List with items
     *  - remove an entire list
     *  - remove a single task
     * try to be as conform to REST standards as possible
     */
}
