package com.cgi.todo_skeleton.model;

import com.cgi.todo_skeleton.view.TaskView;
import com.cgi.todo_skeleton.view.TodoListView;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "todoList")
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String title;
    private String description;
    private LocalDateTime dueDate;

    // #### Foreign Key ####
    // #### Linking task to task_id in Task table ####
    //  @OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
    //  private List<Task> task;

  /*
  Clemens way: hier kein link auf die tasks
   */

    //#### Constructor ###
    public TodoList(
            Integer id,
            String title,
            String description,
            LocalDateTime dueDate
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public TodoList() {}

    //#### Getters  ####
    public Integer getId() {
        return id;
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

    //  public String getTask() {
    //    return task;
    //  }

    //#### Setters  ####
    public void setId(Integer id) {
        this.id = id;
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
    //
    //Todo Getter setter constructor

    public TodoListView toView(List<TaskView> taskViews) {
        return new TodoListView(id, title, description, dueDate, taskViews);
    }

}
