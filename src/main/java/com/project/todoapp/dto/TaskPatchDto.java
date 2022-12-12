package com.project.todoapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TaskPatchDto {
    private long id;

    private String title;

    private int todo_order;

    private boolean completed;

    public void setId(long id) {
        this.id = id;
    }
}
