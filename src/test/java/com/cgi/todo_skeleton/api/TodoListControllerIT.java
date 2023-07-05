package com.cgi.todo_skeleton.api;

import com.cgi.todo_skeleton.TodoSkeletonApplication;
import com.cgi.todo_skeleton.api.TodoListController;
import com.cgi.todo_skeleton.model.TodoList;
import com.cgi.todo_skeleton.repo.TodoListRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

import static groovy.json.JsonOutput.toJson;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {TodoSkeletonApplication.class})
@AutoConfigureMockMvc
public class TodoListControllerIT {

    @Autowired
    private TodoListRepository todoListRepository;
    @Autowired
    private TodoListController todoListController;
    @Autowired
    private MockMvc mockMvc;

    public TodoListControllerIT() {
    }

    @BeforeEach
    void init() {
        // clear database of all lists
        todoListRepository.deleteAll();
    }




    @Test
    public void testGetAllTodoList() throws Exception {

        // Set up any necessary mock behavior for your service
        // Create test data
        var todoList1 = new TodoList(1, "IT1", "IT", LocalDateTime.now());
        var todoList2 = new TodoList(2, "IT2", "IT", LocalDateTime.now());
        var todoList3 = new TodoList(3, "IT3", "IT", LocalDateTime.now());
        var todoList4 = new TodoList(4, "IT4", "IT", LocalDateTime.now());

        //save test data to the database
        todoListRepository.save(todoList1);
        todoListRepository.save(todoList2);
        todoListRepository.save(todoList3);
        todoListRepository.save(todoList4);

        // Perform a request to your controller endpoint and validate the response
       mockMvc.perform(get("/todoList/").contentType(MediaType.APPLICATION_JSON))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$[1].title", is("IT2")))
       ;
    }

    @Test
    public void testAddTodoList() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        // Create a To Do List to Post to DataBase
        TodoList todoList1 = new TodoList(5, "List One of Many", "Another List", LocalDateTime.now());

        // Perform a request to your controller endpoint and validate the response
        mockMvc.perform(
                post("/todoList/")
                .content(objectMapper.writeValueAsString(todoList1))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andDo(print());
        ;
    }

}

