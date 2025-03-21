package com.example.shop.mapper;

import com.example.shop.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    void insertUser(User user);

    User findByUsername(String username);
    User findById(int id);

    void updateUser(User user);

    List<User> findAll();

    void updateUserProperty(int userId, Double newProperty);
}
