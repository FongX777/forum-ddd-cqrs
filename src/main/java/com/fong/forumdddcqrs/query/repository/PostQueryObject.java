package com.fong.forumdddcqrs.query.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostQueryObject extends ElasticsearchRepository<PostESDocument, String> {

    @Query("{\"multi_match\": { \"query\": \"?0\", \"fields\": [\"subject\", \"body\"] } }")
    Page<PostESDocument> findPostsByKeyword(String keyword, Pageable pageable);
}
