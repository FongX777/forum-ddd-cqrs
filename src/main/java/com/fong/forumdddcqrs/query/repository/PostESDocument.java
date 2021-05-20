package com.fong.forumdddcqrs.query.repository;

import static org.springframework.data.elasticsearch.annotations.FieldType.Text;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;


import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "post")
@AllArgsConstructor
@Data
public class PostESDocument {

    @Id
    private String postId;

    @Field(type = Text)
    private String subject;
    @Field(type = Text)
    private String body;

}
