package com.cgi.todo_skeleton.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TodoList {

    @Id
    @GeneratedValue()
    private Integer id;

    private String title;

    private String description;

    private LocalDateTime dueDate;

    //Todo Getter setter constructor
    
}
