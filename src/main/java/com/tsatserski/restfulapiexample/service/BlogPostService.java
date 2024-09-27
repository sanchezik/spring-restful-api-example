package com.tsatserski.restfulapiexample.service;

import com.tsatserski.restfulapiexample.model.BlogPostEntity;
import com.tsatserski.restfulapiexample.model.BlogPostForm;
import com.tsatserski.restfulapiexample.model.BlogPostItem;
import com.tsatserski.restfulapiexample.model.BlogPostWithCommentsItem;
import com.tsatserski.restfulapiexample.model.CommentEntity;
import com.tsatserski.restfulapiexample.model.CommentForm;
import com.tsatserski.restfulapiexample.repository.BlogPostRepository;
import com.tsatserski.restfulapiexample.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public BlogPostService(BlogPostRepository blogPostRepository, CommentRepository commentRepository) {
        this.blogPostRepository = blogPostRepository;
        this.commentRepository = commentRepository;
    }

    public List<BlogPostItem> getAllBlogPosts() {
        List<BlogPostEntity> posts = blogPostRepository.findAll();
        List<BlogPostItem> postItems = new ArrayList<>();
        for (BlogPostEntity entity : posts) {
            BlogPostItem postItem = new BlogPostItem(entity);
            postItem.setCommentsNum(commentRepository.findAllByPostId(entity.getId()).size());
            postItems.add(postItem);
        }
        return postItems;
    }

    public BlogPostWithCommentsItem getBlogPostById(Long postId) {
        Optional<BlogPostEntity> postEntity = blogPostRepository.findById(postId);
        if (postEntity.isEmpty()) {
            // TODO raise exception here
            return new BlogPostWithCommentsItem();
        }
        BlogPostWithCommentsItem postItem = new BlogPostWithCommentsItem(postEntity.get());
        postItem.setComments(commentRepository.findAllByPostId(postItem.getId()));
        return postItem;
    }

    public BlogPostEntity saveNewBlogPost(BlogPostForm postForm) {
        BlogPostEntity postEntity = new BlogPostEntity(postForm.getTitle(), postForm.getContent());
        return blogPostRepository.save(postEntity);
    }

    public CommentEntity saveNewComment(Long postId, CommentForm commentForm) {
        CommentEntity commentEntity = new CommentEntity(postId, commentForm.getText());
        return commentRepository.save(commentEntity);
    }

}
