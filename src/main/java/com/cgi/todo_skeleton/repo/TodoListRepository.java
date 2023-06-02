package com.cgi.todo_skeleton.repo;

import com.cgi.todo_skeleton.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Integer> {

    //TODO add repo for the Tasks, read the docs of how to add methods.

}
