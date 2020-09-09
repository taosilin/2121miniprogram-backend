package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper extends Mapper<Comment> {
    public void addComment(Comment c);
}
