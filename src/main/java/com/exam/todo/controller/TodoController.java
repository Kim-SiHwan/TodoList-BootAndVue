package com.exam.todo.controller;

import com.exam.todo.domain.Todo;
import com.exam.todo.dto.RequestDto;
import com.exam.todo.dto.ResponseDto;
import com.exam.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo/**")
public class TodoController {
    private final TodoService service;

    public ResponseDto.Result getAll(){
        return service.findAll();
    }

    @GetMapping
    public ResponseEntity getTodos(){
        return new ResponseEntity(getAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity addItem(@RequestBody RequestDto requestDto){
        Todo todo = requestDto.toEntity(requestDto);
        service.createItem(todo);
        return new ResponseEntity(getAll(),HttpStatus.CREATED);
    }

    @DeleteMapping("/{itemId}")
    public void removeItem(@PathVariable("itemId") Long itemId){
        service.removeItem(itemId);
    }
}
