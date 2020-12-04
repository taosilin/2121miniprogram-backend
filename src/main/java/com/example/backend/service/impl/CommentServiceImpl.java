package com.example.backend.service.impl;

import com.example.backend.core.ServiceException;
import com.example.backend.dao.CommentMapper;
import com.example.backend.dao.OrderFrameMapper;
import com.example.backend.dao.UserMapper;
import com.example.backend.model.Comment;
import com.example.backend.service.CommentService;
import com.example.backend.core.AbstractService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.backend.web.model.CommentResult;
import com.example.backend.web.model.ReplyRequest;
import com.example.backend.web.model.UserComment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
@Transactional
public class CommentServiceImpl extends AbstractService<Comment> implements CommentService{
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private OrderFrameMapper orderFrameMapper;


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

    public void updateState(Comment c){
        commentMapper.updateState(c);
    }

    public Integer commentTotal(){
        return commentMapper.commentTotal();
    }

    public Comment latestComment(String productID){
        return commentMapper.latestComment(productID);
    }

    public String saveImage(MultipartFile imageFile) throws Exception {
        String folder = "/root/public/comment/";
        byte[] bytes = imageFile.getBytes();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        Path path = Paths.get(folder + date +imageFile.getOriginalFilename());
        Files.write(path,bytes);
        return date + imageFile.getOriginalFilename();
    }

    public List<CommentResult> frameCommentList(String productID){
        List<CommentResult> commentResults = new ArrayList<>();
        List<Comment> comments = commentMapper.commentList(productID);
        for (Comment comment:comments){
            CommentResult commentResult = new CommentResult();
            commentResult.comment = comment;
            commentResult.user = userMapper.findByUserID(comment.getUserID());
        }
        return commentResults;
    }
}
