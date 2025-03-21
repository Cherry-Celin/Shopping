package com.example.shop.mapper;

import com.example.shop.entity.Comment;
import com.example.shop.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> getBoughtOrdersByUsername(@Param("username") String username);
    List<Order> getSellOrdersByUsername(@Param("username") String username);

    void deleteOrder(@Param("orderId") int orderId);

    void addComment(Comment comment);

    Comment getCommentByOrderId(int orderId);

    Order findOrderById(int id);

    void updateOrder(Order order);

    void createOrder(Order order);
}
