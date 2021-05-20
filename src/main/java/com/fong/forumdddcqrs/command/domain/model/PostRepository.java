package com.fong.forumdddcqrs.command.domain.model;


import java.util.Optional;

public interface PostRepository {
    public PostId nextId();
    public Optional<Post> getById(PostId postId);
    public void save(Post post);

}
