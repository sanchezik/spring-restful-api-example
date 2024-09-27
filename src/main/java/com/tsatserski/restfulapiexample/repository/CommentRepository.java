package com.tsatserski.restfulapiexample.repository;

import com.tsatserski.restfulapiexample.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByPostId(Long postId);

}
