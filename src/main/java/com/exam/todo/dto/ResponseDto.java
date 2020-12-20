package com.exam.todo.dto;

import com.exam.todo.domain.Todo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public class ResponseDto {
    private Long itemId;
    private String item;

    public ResponseDto (Todo todo){
        this.itemId= todo.getId();
        this.item= todo.getItem();
    }

    @Data
    @AllArgsConstructor
    public static class Result<T>{
        private T data;
    }
}
