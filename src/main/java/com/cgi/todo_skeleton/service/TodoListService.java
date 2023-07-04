package com.cgi.todo_skeleton.service;

import com.cgi.todo_skeleton.model.TodoList;
import com.cgi.todo_skeleton.repo.TodoListRepository;
import com.cgi.todo_skeleton.view.TaskView;
import com.cgi.todo_skeleton.view.TodoListView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {
    private final TodoListRepository todoListRepository;
    private final TaskService taskService;

    public TodoListService(TodoListRepository todoListRepository, TaskService taskService) {
        this.todoListRepository = todoListRepository;
        this.taskService = taskService;
    }

    //#### Find TodoList All & ID ####
    public final List<TodoList> getTodoLists() {
        return todoListRepository.findAll();
    }

    //#### Find List by ID Then find All Tasks with same list ID ####
    public final TodoListView getTodoListById(int id) {
        TodoList todoList = todoListRepository.findById(id).orElse(null);
        if(todoList != null) {
            List<TaskView> views = taskService.getTasksByTodoListId(todoList.getId());
            return todoList.toView(views);
        } else {
            return null;
        }
    }

    //#### Save TodoList ####
    public final TodoList saveTodoList(TodoList todoList) {
        return todoListRepository.save(todoList);
    }

    //#### Delete TodoList ####
    public final String deleteTodoList(int id) {
        todoListRepository.deleteById(id);
        return id + "Deleted";
    }
}
//
//TODO here should go all logic and all calls to the database
