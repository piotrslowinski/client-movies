package com.pl.britenet.model;

import java.util.List;

public abstract class BaseResultsPage<T> {

    public Integer id;
    public Integer page;
    public Integer total_pages;
    public Integer total_results;
    public List<T> results;

    public BaseResultsPage(Integer id) {
        this.id = id;
    }

    public BaseResultsPage() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
