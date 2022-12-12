package com.project.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class TaskResponseDto {
    private long id;
    private String title;
    private int todo_order;
    private boolean completed;
}
