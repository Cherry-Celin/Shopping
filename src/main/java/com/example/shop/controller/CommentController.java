package com.example.shop.controller;
import com.example.shop.entity.Comment;
import com.example.shop.entity.User;
import com.example.shop.mapper.CommentMapper;
import com.example.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/reviews")
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{sellerId}")
    public List<Comment> getCommentsBySellerId(@PathVariable int sellerId) {
        System.out.println("个人主页的评价");
        List<Comment> comments = commentMapper.getCommentsBySellerId(sellerId);
        for (Comment comment : comments) {
            User buyer = userMapper.findById(comment.getBuyer_id());
            comment.setBuyernickname(buyer.getNickname());
            comment.setBuyerlocation(buyer.getLocation());
            comment.setBuyeravater(buyer.getAvatar());
        }
        System.out.println("评价："+comments);
        return comments;
    }
}
