package com.exam.todo.dto;

import com.exam.todo.domain.Todo;
import lombok.Getter;

@Getter
public class RequestDto {
    private String item;

    public Todo toEntity(RequestDto requestDto){
        return Todo.makeItem()
                .item(requestDto.getItem())
                .build();

    }
}
