package com.zenor.testing.testing.utils;

import com.zenor.testing.testing.entities.Task;
import com.zenor.testing.testing.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Seeder {
    private final TaskRepository taskRepository;

    @Bean
    public void seedTasks() {
        System.out.println("Seeding tasks...");
        for (int i = 0; i < 100; ++i) {
            Task task = new Task(String.format("task %d", i), false);
            taskRepository.save(task);
        }
    }
}
