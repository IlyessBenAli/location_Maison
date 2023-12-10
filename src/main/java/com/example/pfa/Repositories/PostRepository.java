package com.example.pfa.Repositories;
import com.example.pfa.Entites.Comment;
import com.example.pfa.Entites.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
