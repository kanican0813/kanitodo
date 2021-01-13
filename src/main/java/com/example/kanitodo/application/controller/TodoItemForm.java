package com.example.kanitodo.application.controller;

import com.example.kanitodo.infrastructure.entity.TodoItem;
import lombok.Data;

import java.util.List;

public class TodoItemForm {

    private boolean isDone;

    private List<TodoItem> todoItemList;

    public List<TodoItem> getTodoItems() {
        return todoItemList;
    }

    public void setTodoItems(List<TodoItem> todoItemList) {
        this.todoItemList = todoItemList;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
}
