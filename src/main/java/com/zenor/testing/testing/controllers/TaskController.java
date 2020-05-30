package com.zenor.testing.testing.controllers;

import com.zenor.testing.testing.dto.Response;
import com.zenor.testing.testing.entities.Task;
import com.zenor.testing.testing.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public Response<List<Task>> getAll() {
        return new Response<>(taskService.getAll());
    }

    @GetMapping("/{id}")
    public Response<Task> getById(@PathVariable Integer id) {
        return new Response<>(taskService.getById(id));
    }

    @PostMapping("/{id}/done")
    public Response<Task> setTaskDone(@PathVariable Integer id) {
        return new Response<>(taskService.setTaskDone(id));
    }
}
