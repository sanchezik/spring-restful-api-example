package com.tsatserski.restfulapiexample.repository;

import com.tsatserski.restfulapiexample.model.BlogPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPostEntity, Long> {
}