package com.fong.forumdddcqrs.command.domain.model;

public class PostPublished extends DomainEvent<String> {

    private final String subject;
    private final String body;

    public PostPublished(String id, String subject, String body) {
        super(id);
        this.subject = subject;
        this.body = body;
    }
    public PostPublished(Post post) {
        super(post.getPostId().getId());
        this.subject = post.getSubject();
        this.body = post.getBody();
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
