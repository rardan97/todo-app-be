package com.blackcode.todo_app_be.repository;

import com.blackcode.todo_app_be.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
