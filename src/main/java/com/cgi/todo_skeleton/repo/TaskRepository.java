package com.cgi.todo_skeleton.repo;

import com.cgi.todo_skeleton.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
  //#### Standard Methods Already Available in Spring Boot JPA ####
  //#### findBy Id etc that's why Repo is empty ####

  public List<Task> findAllByTodoListId(Integer todoListId);
}
