package com.fong.forumdddcqrs.command.domain.model;

public class DomainEvent<T> {

    private final T id;

    public DomainEvent(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}

