package com.exam.todo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item;

    @Builder(builderMethodName = "makeItem",builderClassName = "makeItem")
    public Todo(Long id,String item){
        this.id=id;
        this.item=item;
    }

    public void changeItem(String changeItem){
        this.item=changeItem;
    }
}
