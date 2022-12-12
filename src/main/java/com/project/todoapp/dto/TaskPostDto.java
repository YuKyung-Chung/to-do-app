package com.project.todoapp.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class TaskPostDto {
    private String title;

    private int todo_order;

    private boolean completed;
}
