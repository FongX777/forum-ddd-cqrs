package com.fong.forumdddcqrs.command.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.time.OffsetDateTime;

@Getter
@Setter(AccessLevel.PRIVATE)
public class Post {
    @NonNull
    public PostId postId;
    @NonNull
    public String subject;
    @NonNull
    public String body;

    public OffsetDateTime creationDate;

    public Post(PostId postId, String subject, String body, OffsetDateTime creationDate) {
        if (subject == "") {
            throw new IllegalArgumentException("Invalid subject");
        }
        if (body == "") {
            throw new IllegalArgumentException("Invalid body");
        }
        this.postId = postId;
        this.subject = subject;
        this.body = body;
        this.creationDate = creationDate;
    }

    public static Post publish(PostId postId, String subject, String body) {
        return new Post(postId, subject, body, OffsetDateTime.now());
    }

}
