package com.example.kanitodo.domain.repository;

import com.example.kanitodo.infrastructure.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITodoItemRepository extends JpaRepository<TodoItem, Long> {
    public List<TodoItem> findByDoneOrderByTitleAsc(boolean done);

    TodoItem findById(long id);
}
