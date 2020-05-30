package com.zenor.testing.testing.repositories;

import com.zenor.testing.testing.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
