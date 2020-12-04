package com.example.backend.web;

import com.example.backend.core.Result;
import com.example.backend.core.ResultGenerator;
import com.example.backend.model.Comment;
import com.example.backend.service.CommentService;
import com.example.backend.web.model.MyRequestBody;
import com.example.backend.web.model.ReplyRequest;
import com.example.backend.web.model.UserComment;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    @PostMapping("/add")
    public Result addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/reply")
    public Result replyComment(@RequestBody ReplyRequest replyRequest){
        commentService.replyComment(replyRequest);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/list")
    public Result commentList(@RequestBody Comment comment){
        List<UserComment> list = commentService.commentList(comment.getProductID());
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/all")
    public Result allComment(@RequestBody MyRequestBody myRequestBody){
        List<Comment> list = commentService.allComment(myRequestBody.page, myRequestBody.size);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/update")
    public Result updateState(@RequestBody Comment comment){
        commentService.updateState(comment);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/total")
    public Integer commentTotal(){
        return commentService.commentTotal();
    }

    @PostMapping("/latest")
    public Result latestComment(@RequestBody Comment comment){
        Comment c = commentService.latestComment(comment.getProductID());
        return ResultGenerator.genSuccessResult(c);
    }

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
        String returnValue = "start";
        try {
            String fileName = commentService.saveImage(imageFile);
            returnValue = "https://from2121.com/pictures/comment/"+ fileName;
        } catch (Exception e) {
            e.printStackTrace();
            returnValue = "error";
        }
        return returnValue;
    }
}
