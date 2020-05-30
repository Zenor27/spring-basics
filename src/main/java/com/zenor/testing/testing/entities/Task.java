package com.zenor.testing.testing.entities;

import lombok.*;

@Builder
@javax.persistence.Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Task extends com.zenor.testing.testing.entities.Entity {
    private String name;
    private boolean isDone;
}
