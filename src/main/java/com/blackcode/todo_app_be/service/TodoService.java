package com.blackcode.todo_app_be.service;

import com.blackcode.todo_app_be.dto.TodoReq;
import com.blackcode.todo_app_be.dto.TodoRes;
import com.blackcode.todo_app_be.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TodoService {

    List<TodoRes> getTodoListAll();

    TodoRes getTodoById(Long id);

    TodoRes addTodo(TodoReq todo);

    TodoRes updateTodo(Long id, TodoReq todo);

    String deleteTodo(Long id);

}
