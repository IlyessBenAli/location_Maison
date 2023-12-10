package com.example.pfa.Services;

import com.example.pfa.Entites.Comment;
import com.example.pfa.Entites.Comment;

import java.util.List;

public interface IComment {
    List<Comment> getAll();

    void saveComment(Comment comment,Long idpost);

    Comment getCommentById(Long id);

    void deleteComment(Long id);

    Comment updateComment(Long id, Comment comment);

}
