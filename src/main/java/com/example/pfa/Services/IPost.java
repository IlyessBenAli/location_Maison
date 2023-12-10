package com.example.pfa.Services;

 import com.example.pfa.Entites.Post;

import java.util.List;

public interface IPost {
    List<Post> getAll();

    void savePost(Post post);

    Post getPostById(Long id);

    void deletePost(Long id);

    Post updatePost(Long id, Post post);
  Post   updatePostLikes(Long id,int likes);
}
