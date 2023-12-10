package com.example.pfa.RestController;

import com.example.pfa.Entites.Comment;
import com.example.pfa.Entites.Post;
import com.example.pfa.Services.IComment;
import com.example.pfa.Services.IPost;
import com.example.pfa.exceptions.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Transactional
@RequestMapping(value = "/api/comments", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {

    @Autowired
    IComment commentService;
    @Autowired
    IPost postService;


    @PostMapping("/{idpst}")


    public ResponseEntity<Comment> createComment(@RequestBody Comment comment,@PathVariable Long idpst) {

        // Enregistrer le commentaire
        commentService.saveComment(comment,idpst);

        return new ResponseEntity<Comment>(comment, HttpStatus.CREATED);
    }



    @GetMapping
    public List<Comment> getAllComments() {
        return commentService.getAll();
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        return commentService.updateComment(id, comment);
    }

    @DeleteMapping("/{id}")
    public void deleteCommentById(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

}
