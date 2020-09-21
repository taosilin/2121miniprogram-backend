package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.CommentMapper;
import com.example.backend.dao.UserMapper;
import com.example.backend.model.Comment;
import com.example.backend.service.CommentService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.web.model.ReplyRequest;
import com.example.backend.web.model.UserComment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Transactional
public class CommentServiceImpl extends AbstractService<Comment> implements CommentService{
    @Resource
    private CommentMapper commentMapper;

    @Resource
    private UserMapper userMapper;

    public void addComment(Comment c){
        commentMapper.addComment(c);
    }

    public void replyComment(ReplyRequest r){
        commentMapper.replyComment(r);
    }

    public List<UserComment> commentList(String productID){
        List<UserComment> userComments = new ArrayList<>();
        List<Comment> comments = commentMapper.commentList(productID);
        for (Comment comment:comments){
            UserComment userComment = new UserComment();
            userComment.user = userMapper.findByUserID(comment.getUserID());
            userComment.comment = comment;
            userComments.add(userComment);
        }
        return userComments;
    }

    public List<Comment> allComment(Integer page,Integer size){
        return commentMapper.allComment(page*size, size);
    }
}
