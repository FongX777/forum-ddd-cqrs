package com.fong.forumdddcqrs.query.query;

import lombok.Data;

@Data
public class SearchPostQuery {
    private String keyword;

    public SearchPostQuery(String keyword) {
        this.keyword = keyword;
    }
}
