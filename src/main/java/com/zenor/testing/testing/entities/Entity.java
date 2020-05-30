package com.zenor.testing.testing.entities;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity
@Getter
public abstract class Entity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected int id;
}
