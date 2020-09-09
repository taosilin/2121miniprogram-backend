package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.CommentMapper;
import com.example.backend.model.Comment;
import com.example.backend.service.CommentService;
import com.example.backend.core.AbstractService;

import java.util.ArrayList;
import java.util.List;

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

    public void addComment(Comment c){
        commentMapper.addComment(c);
    }
}
