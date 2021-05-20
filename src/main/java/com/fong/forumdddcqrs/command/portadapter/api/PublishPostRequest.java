package com.fong.forumdddcqrs.command.portadapter.api;

import lombok.Data;

@Data
public class PublishPostRequest {
    private String subject;
    private String body;
}
