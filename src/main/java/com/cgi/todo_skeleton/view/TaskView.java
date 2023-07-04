package com.cgi.todo_skeleton.view;

public class TaskView {

    private String description;
    private Boolean isDone;
    private Integer todoListId;

    public TaskView(String description, Boolean isDone) {
        this.description = description;
        this.isDone = isDone;
        this.todoListId = todoListId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public Integer todoListId() {
        return todoListId;
    }
}
