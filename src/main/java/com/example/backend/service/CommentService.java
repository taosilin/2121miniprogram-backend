package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Comment;
import com.example.backend.web.model.ReplyRequest;
import com.example.backend.web.model.UserComment;

import java.util.List;

public interface CommentService extends Service<Comment> {
    void addComment(Comment c);
    void replyComment(ReplyRequest r);
    List<UserComment> commentList(String productID);
    List<Comment> allComment(Integer page,Integer size);
    void updateState(Comment c);
}
