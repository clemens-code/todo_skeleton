package com.cgi.todo_skeleton.service;

import com.cgi.todo_skeleton.model.Task;
import com.cgi.todo_skeleton.repo.TaskRepository;
import com.cgi.todo_skeleton.view.TaskView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

  private final TaskRepository taskRepository;

  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  //#### Find Tasks All & By ID  ####
  public List<Task> getTasks() {
    return taskRepository.findAll();
  }

  public TaskView getTaskById(int id) {
    Task task = taskRepository.findById(id).orElse(null);
    if (task != null) {
      return task.toTaskView();
    } else {
      return null;
    }
  }

  //#### Delete Task ####
  public final String deleteTask(int id) {
    taskRepository.deleteById(id);
    return id + "Deleted";
  }

//####  List Tasks by ToDoList ID  All Tasks on 1 List ####
  public List<TaskView> getTasksByTodoListId(int todoListId) {
    List<Task> tasks = taskRepository.findAllByTodoListId(todoListId);
    return tasks.stream().map(Task::toTaskView).collect(Collectors.toList());
  }


}
