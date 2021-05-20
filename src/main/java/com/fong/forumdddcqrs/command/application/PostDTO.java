package com.fong.forumdddcqrs.command.application;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class PostDTO {
    private String postId;
    private String subject;
    private String body;
    private OffsetDateTime creationDate;
}
