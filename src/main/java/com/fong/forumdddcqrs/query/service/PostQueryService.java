package com.fong.forumdddcqrs.query.service;

import com.fong.forumdddcqrs.command.domain.model.PostPublished;
import com.fong.forumdddcqrs.query.query.SearchPostQuery;
import com.fong.forumdddcqrs.query.repository.PostESDocument;
import com.fong.forumdddcqrs.query.repository.PostQueryObject;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PostQueryService {

    @Autowired
    private PostQueryObject postQueryObject;

    @EventHandler
    public void on(PostPublished event) {
        log.info("Handling PostPublished...", event.getBody());
        PostESDocument doc = new PostESDocument(event.getId(), event.getSubject(), event.getBody());
        this.postQueryObject.save(doc);
    }

    @QueryHandler
    public PostESDocument[] handle(SearchPostQuery query) {
        log.info("Handling SearchPostQuery...", query.getKeyword());

        Page<PostESDocument> postESDocumentPage = this.postQueryObject.findPostsByKeyword(query.getKeyword(), PageRequest.of(0, 10));

        return postESDocumentPage.stream().toArray(PostESDocument[]::new);
    }


}
