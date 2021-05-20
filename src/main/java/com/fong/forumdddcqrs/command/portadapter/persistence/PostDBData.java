package com.fong.forumdddcqrs.command.portadapter.persistence;

import lombok.Data;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Data
@Entity
@Aggregate
public class PostDBData {
    @Id
    private String postId;
    private String subject;
    private String body;
    private OffsetDateTime creationDate;

    protected PostDBData() {
    }

    public PostDBData(String postId, String subject, String body, OffsetDateTime creationDate) {
        this.postId = postId;
        this.subject = subject;
        this.body = body;
        this.creationDate = creationDate;
    }

}
