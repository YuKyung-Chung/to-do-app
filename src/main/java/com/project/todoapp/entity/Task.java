package com.project.todoapp.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
public class Task {
    @Id
    private long id;
    private String title;
    private int todo_order;
    private boolean completed;



    /*
    * taskId: autoincrement
    * title: 운동하기, 공부하기
    * order: 1, 2
    * completed: false(default), true
    * */
}
