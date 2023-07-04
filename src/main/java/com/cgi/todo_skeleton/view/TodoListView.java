package com.cgi.todo_skeleton.view;

import java.time.LocalDateTime;
import java.util.List;

public class TodoListView {

    private Integer id;

    private String title;

    private String description;

    private LocalDateTime dueDate;

    private List<TaskView> tasks;

    public TodoListView(
            Integer id,
            String title,
            String description,
            LocalDateTime dueDate,
            List<TaskView> tasks
    ) {
        this.id=id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.tasks = tasks;
    }

    //#### Getter & Setters ####


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public List<TaskView> getTasks() {
        return tasks;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setTasks(List<TaskView> tasks) {
        this.tasks = tasks;
    }
    //
    //TODO add a TaskView, getters, ...

}
