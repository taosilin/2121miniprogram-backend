package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Comment;

public interface CommentService extends Service<Comment> {
    void addComment(Comment c);
}
