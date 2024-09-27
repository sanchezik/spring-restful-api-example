package com.tsatserski.restfulapiexample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CommentEntity {

    @Id
    @GeneratedValue
    private Long id;
    private Long postId;
    @Column(length = 500)
    private String text;

    public CommentEntity() {
    }

    public CommentEntity(Long postId, String text) {
        this.postId = postId;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
