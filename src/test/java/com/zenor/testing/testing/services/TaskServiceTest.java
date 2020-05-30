package com.zenor.testing.testing.services;

import com.zenor.testing.testing.entities.Task;
import com.zenor.testing.testing.repositories.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void getAllNotEmpty() {
        // Given
        Task task = new Task("Task1", false);
        Task task2 = new Task("Task2", false);
        Task task3 = new Task("Task3", false);

        given(taskRepository.findAll()).willReturn(asList(task, task2, task3));

        // When
        var tasks = taskService.getAll();

        // Then
        assertThat(tasks).containsExactly(task, task2, task3);
    }

    @Test
    void getByIdExisting() {
        // Given
        Task task = new Task("Task", false);
        given(taskRepository.findById(1)).willReturn(java.util.Optional.of(task));

        // When
        var returnedTask = taskService.getById(1);

        // Then
        assertThat(returnedTask).isNotNull();
    }

    @Test
    void getByIdNonExisting() {
        // Given
        given(taskRepository.findById(1)).willReturn(Optional.empty());

        // When
        var returnedTask = taskService.getById(1);

        // Then
        assertThat(returnedTask).isNull();
    }
}
