package com.example.InstaCopy.repository;

import com.example.InstaCopy.entity.Post;
import com.example.InstaCopy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUserOrderByCreatedDateDesc(User user);
    List<Post> findAllByOrderBOrderByCreatedDateDesc();
    Optional<Post> findPostByIdAndUser(Long id, User user);
}
