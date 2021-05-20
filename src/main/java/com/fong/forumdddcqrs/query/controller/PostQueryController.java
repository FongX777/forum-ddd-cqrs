package com.fong.forumdddcqrs.query.controller;

import com.fong.forumdddcqrs.query.query.SearchPostQuery;
import com.fong.forumdddcqrs.query.repository.PostESDocument;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostQueryController {

    private final QueryGateway queryGateway;

    public PostQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/search")
    public ResponseEntity<PostESDocument[]> searchPosts(@RequestParam String keyword) {
        PostESDocument[] docs = queryGateway.query(
                new SearchPostQuery(keyword), PostESDocument[].class
        ).join();

        return new ResponseEntity<>(docs, HttpStatus.OK);
    }

}
