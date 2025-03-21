package com.example.shop.controller;

import com.example.shop.entity.Comment;
import com.example.shop.entity.Order;
import com.example.shop.entity.Product;
import com.example.shop.entity.User;
import com.example.shop.mapper.OrderMapper;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/bought/{username}")
    public List<Order> getBoughtOrdersByUsername(@PathVariable String username) {
        System.out.println("买到的bought"+username);
        System.out.println("买到的bought："+orderMapper.getBoughtOrdersByUsername(username));
        return orderMapper.getBoughtOrdersByUsername(username);
    }

    @GetMapping("/sell/{username}")
    public List<Order> getSellOrdersByUsername(@PathVariable String username) {
        System.out.println("卖出的sell"+username);
        System.out.println("卖出的sell："+orderMapper.getSellOrdersByUsername(username));
        return orderMapper.getSellOrdersByUsername(username);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable int orderId) {
        orderMapper.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/comment")
    public ResponseEntity<Void> addComment(
            @RequestParam("content") String content,
            @RequestParam("orderId") int orderId) {

        System.out.println("进入评价");

        // 根据orderId找到订单
        Order order = orderMapper.findOrderById(orderId);
        if (order == null || order.getUser() == null) {
            return ResponseEntity.notFound().build();
        }

        // 创建评论对象
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setBuyer_id(order.getUser().getId());
        comment.setSeller_id(order.getSeller_id());

        // 插入评论
        orderMapper.addComment(comment);

        // 更新订单的comment_id
        order.setComment(comment);
        orderMapper.updateOrder(order);

        System.out.println("发送的评价: " + comment);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{orderId}/comment")
    public ResponseEntity<Comment> getCommentByOrderId(@PathVariable int orderId) {
        System.out.println("查看评价");
        Comment comment = orderMapper.getCommentByOrderId(orderId);
        if (comment == null) {
            return ResponseEntity.noContent().build();
        }
        System.out.println("评价："+ comment);
        return ResponseEntity.ok(comment);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createOrder(
            @RequestParam("buyerId") int buyerId,
            @RequestParam("sellerId") int sellerId,
            @RequestParam("productId") int productId,
            @RequestParam("address") String address) {
        System.out.println("创建订单");
        Order order = new Order();
        User user=userMapper.findById(buyerId);
        user.setDetail_address(address);
        userMapper.updateUser(user);
        order.setUser(user);
        order.setSeller_id(sellerId);
        Product product=productMapper.getProductById(productId);
        order.setProduct(product);
        order.setCreate_time(new Date());
        order.setUpdate_time(new Date());
        order.setIs_deleted(false);
        orderMapper.createOrder(order);
        return ResponseEntity.ok().build();
    }
}
