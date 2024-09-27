package com.tsatserski.restfulapiexample.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import com.tsatserski.restfulapiexample.model.BlogPostEntity;
import com.tsatserski.restfulapiexample.model.BlogPostForm;
import com.tsatserski.restfulapiexample.model.BlogPostItem;
import com.tsatserski.restfulapiexample.model.BlogPostWithCommentsItem;
import com.tsatserski.restfulapiexample.model.CommentEntity;
import com.tsatserski.restfulapiexample.model.CommentForm;
import com.tsatserski.restfulapiexample.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// tag::hateoas-imports[]
// end::hateoas-imports[]

@RestController
@RequestMapping("/api")
public class PostsController {

    private final BlogPostService blogPostService;

    @Autowired
    public PostsController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    // tag::get-aggregate-root[]
    @GetMapping("/posts")
    CollectionModel<EntityModel<BlogPostItem>> allPosts() {

        List<EntityModel<BlogPostItem>> employees = blogPostService.getAllBlogPosts().stream()
                .map(blogPost -> EntityModel.of(blogPost,
                        linkTo(methodOn(PostsController.class).onePost(blogPost.getId())).withSelfRel(),
                        linkTo(methodOn(PostsController.class).allPosts()).withRel("blogPosts")))
                .collect(Collectors.toList());

        return CollectionModel.of(employees, linkTo(methodOn(PostsController.class).allPosts()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/posts")
    BlogPostEntity newPost(@RequestBody BlogPostForm newPostForm) {
        return blogPostService.saveNewBlogPost(newPostForm);
    }

    // tag::get-single-item[]
    @GetMapping("/posts/{id}")
    EntityModel<BlogPostWithCommentsItem> onePost(@PathVariable Long id) {

        BlogPostWithCommentsItem blogPost = blogPostService.getBlogPostById(id);

        return EntityModel.of(blogPost,
                linkTo(methodOn(PostsController.class).onePost(id)).withSelfRel(),
                linkTo(methodOn(PostsController.class).allPosts()).withRel("blogPosts"));
    }
    // end::get-single-item[]

    @PostMapping("/posts/{id}/comments")
    CommentEntity newComment(@RequestBody CommentForm commentForm, @PathVariable Long id) {
        return blogPostService.saveNewComment(id, commentForm);
    }

}