package com.project.todoapp.repository;

import com.project.todoapp.entity.Task;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {
    //Optional<Task> findByTaskId(Long taskId);

    @Query("SELECT * FROM TASK WHERE ID = :id")
    Optional<Task> findById(Long id);

}
