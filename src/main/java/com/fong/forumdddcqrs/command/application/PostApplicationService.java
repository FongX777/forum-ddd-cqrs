package com.fong.forumdddcqrs.command.application;


import com.fong.forumdddcqrs.command.domain.model.PostId;
import com.fong.forumdddcqrs.command.domain.model.Post;
import com.fong.forumdddcqrs.command.domain.model.PostPublished;
import com.fong.forumdddcqrs.command.domain.model.PostRepository;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.gateway.EventGateway;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Aggregate
public class PostApplicationService {
    @Autowired
    private PostRepository postRepo;
    @Autowired
    private EventGateway eventGateway;

    @Value
    public static class GetPostCommand {
        private String postId;
    }

    public PostDTO getPost(GetPostCommand command) {
        PostId postId = new PostId(command.getPostId());
        Optional<Post> post = this.postRepo.getById(postId);

        if (post.isPresent()) {
            return this.toPostDTO(post.get());
        }
        return null;
    }


    @Value
    public static class PublishPostCommand {
        private String subject;
        private String body;
    }

    public String publishPost(PublishPostCommand command) {
        PostId postId = this.postRepo.nextId();
        Post post = Post.publish(postId, command.getSubject(), command.getBody());
        this.postRepo.save(post);
        eventGateway.publish(new PostPublished(post));
        return post.postId.getId();
    }


    private PostDTO toPostDTO(Post post) {
        return new PostDTO(post.getPostId().getId(), post.getSubject(), post.getBody(), post.getCreationDate());
    }
}