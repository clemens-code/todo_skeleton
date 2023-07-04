package com.cgi.todo_skeleton.model;

import com.cgi.todo_skeleton.view.TaskView;
import jakarta.persistence.*;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String description;
    private Boolean isDone;

    private Integer todoListId;

/*  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "task_id")
  private TodoList todoList;*/

    /*
    Clemens way:
     */



    //#### Constructor ####

    public Task(Integer id, String description, Boolean done) {
        this.id = id;
        this.description = description;
        this.isDone = done;
    }

    public Task(Integer id, String description, Boolean done, Integer todoListId) {
        this.id = id;
        this.description = description;
        this.isDone = done;
        this.todoListId = todoListId;
    }

    public Task() {
    }

    //#### Getters  ####
    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    //#### Setters  ####
    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public Integer getTodoListId() {
        return todoListId;
    }

    public void setTodoListId(Integer todoListId) {
        this.todoListId = todoListId;
    }

    public TaskView toTaskView() {
        return new TaskView(description, isDone);
    }
    //
    //TODO define your task as you like, dont forget the foreign key of the todoList

    TaskView toView() {
        return new TaskView(description, isDone);
    }
}
