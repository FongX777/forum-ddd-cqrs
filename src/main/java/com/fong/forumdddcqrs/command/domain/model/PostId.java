package com.fong.forumdddcqrs.command.domain.model;

import lombok.Value;

@Value
public class PostId {
    private String id;

    public PostId(String id) {
        if (id.length() < 1) {
            throw new IllegalArgumentException("Invalid id");
        }
        this.id = id;
    }


    @Override
    public String toString() {
        return this.id;
    }
}
