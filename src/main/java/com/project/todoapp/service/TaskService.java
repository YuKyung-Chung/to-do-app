package com.project.todoapp.service;

import com.project.todoapp.entity.Task;
import com.project.todoapp.exception.BusinessLogicException;
import com.project.todoapp.exception.ExceptionCode;
import com.project.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        Long id = task.getId();
        verifyExistTask(id);
        task.setId(id);

        return taskRepository.save(task);
    }

    private void verifyExistTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent())
            throw new BusinessLogicException(ExceptionCode.TASK_EXISTS);
    }

    public Task updateTask(Task task) {

        return taskRepository.save(task);
    }

    public Task findTask(long id) {
        return findVerifiedTaskByQuery(id);
    }

    private Task findVerifiedTaskByQuery(long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        Task findTask =
                optionalTask.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.TASK_NOT_FOUND));

        return findTask;
    }

    public List<Task> findTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    public void deleteTask(long id) {
        Task task = findVerifiedTask(id);
        taskRepository.delete(task);
    }

    private Task findVerifiedTask(long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        Task findTask = optionalTask.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.TASK_NOT_FOUND));
        return findTask;
    }

    public void deleteAll() {
        taskRepository.deleteAll();
    }


}
