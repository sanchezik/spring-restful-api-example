package com.tsatserski.restfulapiexample.model;

public class BlogPostItem {

    private Long id;
    private String title;
    private Integer commentsNum;

    public BlogPostItem() {
    }

    public BlogPostItem(BlogPostEntity blogPostEntity) {
        this.id = blogPostEntity.getId();
        this.title = blogPostEntity.getTitle();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCommentsNum() {
        return commentsNum;
    }

    public void setCommentsNum(Integer commentsNum) {
        this.commentsNum = commentsNum;
    }
}
