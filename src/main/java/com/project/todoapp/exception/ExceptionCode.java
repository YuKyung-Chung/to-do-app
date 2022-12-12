package com.project.todoapp.exception;

import lombok.Getter;

public enum ExceptionCode {
    TASK_NOT_FOUND(404, "Task not found"),
    TASK_EXISTS(409, "Task exists"),
    NOT_IMPLEMENTATION(501, "Not Implementation");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
