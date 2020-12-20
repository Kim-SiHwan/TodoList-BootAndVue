package com.exam.todo.service;

import com.exam.todo.domain.Todo;
import com.exam.todo.dto.ResponseDto;
import com.exam.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TodoService {
    private final TodoRepository repository;

    public ResponseDto.Result findAll(){
        List<Todo> todos = repository.findAll();
        List<ResponseDto> list = todos.stream()
                .map(todo -> new ResponseDto(todo))
                .collect(Collectors.toList());
        return new ResponseDto.Result(list);
    }

    @Transactional
    public Long createItem(Todo todo){
        repository.save(todo);
        return todo.getId();
    }


    @Transactional
    public void removeItem(Long itemId){
        Todo todo= repository.findById(itemId).get();
        repository.delete(todo);
    }
}
