package com.tsatserski.restfulapiexample.model;

import java.util.List;

public class BlogPostWithCommentsItem {

    private Long id;
    private String title;
    private String content;
    private List<CommentEntity> comments;

    public BlogPostWithCommentsItem() {
    }

    public BlogPostWithCommentsItem(BlogPostEntity postEntity) {
        this.id = postEntity.getId();
        this.title = postEntity.getTitle();
        this.content = postEntity.getContent();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
}
