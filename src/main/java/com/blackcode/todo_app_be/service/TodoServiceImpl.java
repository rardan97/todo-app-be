package com.blackcode.todo_app_be.service;

import com.blackcode.todo_app_be.dto.TodoReq;
import com.blackcode.todo_app_be.dto.TodoRes;
import com.blackcode.todo_app_be.model.Todo;
import com.blackcode.todo_app_be.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<TodoRes> getTodoListAll() {
        List<TodoRes> dataTodo = new ArrayList<>();
        List<Todo> data = todoRepository.findAll();
        for (Todo temp : data){
            TodoRes todoRow = new TodoRes();
            todoRow.setId(temp.getId());
            todoRow.setTitle(temp.getTitle());
            todoRow.setDescription(temp.getDescription());
            todoRow.setStatus(temp.getStatus());
            dataTodo.add(todoRow);
        }
        return dataTodo;
    }

    @Override
    public TodoRes getTodoById(Long id) {
        TodoRes todoRtn = null;
        Optional<Todo> dataTodo = todoRepository.findById(id);
        if (dataTodo.isPresent()){
            todoRtn = new TodoRes();
            todoRtn.setId(dataTodo.get().getId());
            todoRtn.setTitle(dataTodo.get().getTitle());
            todoRtn.setDescription(dataTodo.get().getDescription());
            todoRtn.setStatus(dataTodo.get().getStatus());
        }
        return todoRtn;
    }

    @Override
    public TodoRes addTodo(TodoReq todo) {
        Todo todo1 = new Todo();
        todo1.setTitle(todo.getTitle());
        todo1.setDescription(todo.getDescription());
        todo1.setStatus(todo.getStatus());
        Todo saveTodo = todoRepository.save(todo1);
        return TodoRes.builder()
                .id(saveTodo.getId())
                .title(saveTodo.getTitle())
                .description(saveTodo.getDescription())
                .status(saveTodo.getStatus())
                .build();
    }

    @Override
    public TodoRes updateTodo(Long id, TodoReq todo) {
        Todo saveTodo = null;
        Optional<Todo> dataTodo = todoRepository.findById(id);
        if(dataTodo.isPresent()){
            Todo todo1 = new Todo();
            System.out.println("id : "+dataTodo.get().getId());
            System.out.println("title : "+todo.getTitle());
            System.out.println("desc : "+todo.getDescription());
            System.out.println("status : "+todo.getStatus());
            todo1.setId(dataTodo.get().getId());
            todo1.setTitle(todo.getTitle());
            todo1.setDescription(todo.getDescription());
            todo1.setStatus(todo.getStatus());
            saveTodo = todoRepository.save(todo1);

            return TodoRes.builder()
                    .id(saveTodo.getId())
                    .title(saveTodo.getTitle())
                    .description(saveTodo.getDescription())
                    .status(saveTodo.getStatus())
                    .build();
        }
        return null;

    }

    @Override
    public String deleteTodo(Long id) {
        Optional<Todo> dataTodo = todoRepository.findById(id);
        String rtn = "";
        if(dataTodo.isPresent()) {
            todoRepository.deleteById(id);
            rtn = "Delete Success";

        }
        return rtn;
    }
}
