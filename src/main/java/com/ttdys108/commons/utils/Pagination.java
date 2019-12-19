package com.ttdys108.commons.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pagination<T> {

    private Long totalCount;

    private List<T> results;

    public Pagination() {

    }

    public static <V> Pagination<V> create(List<V> results, Long totalCount) {
        Pagination<V> pagination = new Pagination();
        pagination.setResults(results);
        pagination.setTotalCount(totalCount);
        return pagination;
    }

}
