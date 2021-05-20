package com.fong.forumdddcqrs.command.portadapter.persistence;

import com.fong.forumdddcqrs.command.domain.model.Post;
import com.fong.forumdddcqrs.command.domain.model.PostId;
import com.fong.forumdddcqrs.command.domain.model.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class JPAPostRepository implements PostRepository  {
    @Autowired
    PostDBDataDao postDataDao;

    public PostId nextId() {
       return new PostId(UUID.randomUUID().toString());
    }
    public Optional<Post> getById(PostId postId) {
        Optional<PostDBData> dbData = this.postDataDao.findById(postId.getId());

        return dbData.isPresent() ? dbData.map(data -> toModel(data)) : Optional.empty();
    }

    public void save(Post post) {
        this.postDataDao.save(toDBData(post));
        return;
    }

    private PostDBData toDBData(Post post) {
        return new PostDBData(post.postId.getId(), post.getSubject(), post.getBody(), post.getCreationDate());
    }
    private Post toModel(PostDBData data) {
        return new Post(new PostId(data.getPostId()), data.getSubject(), data.getBody(), data.getCreationDate());
    }

}
