package com.project.todoapp.controller;

import com.project.todoapp.dto.TaskPatchDto;
import com.project.todoapp.dto.TaskPostDto;
import com.project.todoapp.dto.TaskResponseDto;
import com.project.todoapp.entity.Task;
import com.project.todoapp.mapper.TaskMapper;
import com.project.todoapp.service.TaskService;
import com.project.todoapp.utils.UriCreator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RequestMapping("/v1/tasks")
@RestController
@CrossOrigin(origins = "https://todobackend.com")
@Slf4j
public class TaskController {
    //private final static String TASK_DEFAULT_URL = "/v1/tasks";
    private final TaskService taskService;
    private final TaskMapper mapper;

    public TaskController(TaskService taskService, TaskMapper mapper) {
        this.taskService = taskService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postTask(@Valid @RequestBody TaskPostDto taskPostDto) {
        Task task = taskService.createTask(mapper.taskPostDtoToTask(taskPostDto));
        //URI location = UriCreator.createUri(TASK_DEFAULT_URL, task.getId()); // "/v1/tasks/{id}"
        return new ResponseEntity<>(mapper.taskToTaskResponseDto(task), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchTask(@PathVariable("id") @Positive long id,
                                    @Valid @RequestBody TaskPatchDto taskPatchDto) {
        taskPatchDto.setId(id);;
        Task task = taskService.updateTask(mapper.taskPatchDtoToTask(taskPatchDto));

        return new ResponseEntity<>(mapper.taskToTaskResponseDto(task), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTask(@PathVariable("id") long id) {
        Task task = taskService.findTask(id);

        return new ResponseEntity<>(mapper.taskToTaskResponseDto(task), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTasks() {
        List<Task> tasks = taskService.findTasks();
        List<TaskResponseDto> response = mapper.tasksToTaskResponseDtos(tasks);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable("id") long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
