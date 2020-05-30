package com.zenor.testing.testing.services;

import com.zenor.testing.testing.entities.Task;
import com.zenor.testing.testing.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAll() {
        ArrayList<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    public Task getById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task setTaskDone(Integer id) {
        return taskRepository.findById(id).map(task -> {
                    task.setDone(true);
                    taskRepository.save(task);
                    return task;
                }
        ).orElse(null);
    }


}
