package com.cgi.todo_skeleton.repo;

import com.cgi.todo_skeleton.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Integer> {
    //#### Standard Methods Already Available in Spring Boot JPA ####
    //#### findBy Id etc that's why Repo is empty ####

    // SELECT * FROM todo_list WHERE description LIKE :des;
    public List<TodoList> findAllByDescription(String des);
    //TODO add repo for the Tasks, read the docs of how to add methods.

}
