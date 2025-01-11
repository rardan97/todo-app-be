package com.blackcode.todo_app_be.controller;


import com.blackcode.todo_app_be.dto.TodoReq;
import com.blackcode.todo_app_be.dto.TodoRes;
import com.blackcode.todo_app_be.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/getListAll")
    public ResponseEntity<List<TodoRes>> getListAll(){
        try {
            List<TodoRes> dataTodo = todoService.getTodoListAll();
            return new ResponseEntity<List<TodoRes>>(dataTodo, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getValueById/{id}")
    public ResponseEntity<TodoRes> getValueById(@PathVariable("id") Long todoId){
        try {
            TodoRes rtnData = todoService.getTodoById(todoId);
            return new ResponseEntity<TodoRes>(rtnData, HttpStatus.OK);
        }catch (NoSuchElementException err){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createTodo")
    public ResponseEntity<TodoRes> createTodo(@RequestBody TodoReq todoReq){
        System.out.println("Check create");
        try{
            TodoRes rtnData = todoService.addTodo(todoReq);
            return new ResponseEntity<TodoRes>(rtnData, HttpStatus.OK);
        }catch (NoSuchElementException err){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateTodo/{id}")
    public ResponseEntity<TodoRes> updateTodo(@PathVariable("id") Long todoId, @RequestBody TodoReq todoReq){
        try {
            TodoRes dataTodo = todoService.updateTodo(todoId, todoReq);
            if(dataTodo != null){
                return new ResponseEntity<TodoRes>(dataTodo, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (NoSuchElementException err){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteTodo/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        try {
            String rtn = todoService.deleteTodo(todoId);
            return new ResponseEntity<String>(rtn, HttpStatus.OK);

        }catch (NoSuchElementException err){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
