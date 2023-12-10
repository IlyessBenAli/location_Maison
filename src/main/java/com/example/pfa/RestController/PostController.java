package com.example.pfa.RestController;

 import com.example.pfa.Entites.Post;
 import com.example.pfa.Repositories.PostRepository;
 import com.example.pfa.Services.IPost;
 import com.example.pfa.exceptions.ErrorStrings;
 import com.example.pfa.exceptions.MyInternalServerErrorException;
 import com.example.pfa.exceptions.MyNotFoundException;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Transactional
@RequestMapping(value = "/api/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {
    @Autowired
    IPost postService;
@Autowired
    PostRepository postRepository;
    @PostMapping()
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        postService.savePost(post);
        return new ResponseEntity<Post>(post, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAll();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/likes/{id}/{likes}")
    public Post updatePostLikes(@PathVariable Long id, @PathVariable Integer likes) {
        Post post = postRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.Post_NOT_FOUND));

        try {
            post.setLikes(likes);
            postRepository.save(post);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }

        return post;
    }







    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
