package com.project.todoapp.mapper;

import com.project.todoapp.dto.TaskPatchDto;
import com.project.todoapp.dto.TaskPostDto;
import com.project.todoapp.dto.TaskResponseDto;
import com.project.todoapp.entity.Task;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task taskPostDtoToTask(TaskPostDto taskPostDto);

    Task taskPatchDtoToTask(TaskPatchDto taskPatchDto);

    TaskResponseDto taskToTaskResponseDto(Task task);

    List<TaskResponseDto> tasksToTaskResponseDtos(List<Task> tasks);
}
