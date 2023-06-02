package com.cgi.todo_skeleton.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Integer id;

    //TODO define your task as you like, dont forget the foreign key of the todoList
}
