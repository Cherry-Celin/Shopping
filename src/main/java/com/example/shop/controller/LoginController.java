package com.example.shop.controller;

import com.example.shop.entity.User;
import com.example.shop.mapper.UserMapper;
import com.example.shop.utils.MD5Utils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("用户不存在");
        }

        String encryptedPassword = MD5Utils.getMD5(password);
        System.out.println("Received login request with username: " + username + " and password: " + encryptedPassword);

        if (!user.getPassword().equals(encryptedPassword)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("密码错误");
        }

        return ResponseEntity.ok("登录成功");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username, @RequestParam String password,
                                           @RequestParam String nickname, @RequestParam String email) {
        User existingUser = userMapper.findByUsername(username);
        if (existingUser != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("用户名已存在，请设置其他用户名");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(MD5Utils.getMD5(password));
        user.setNickname(nickname);
        user.setEmail(email);
        user.setCreate_time(new Date());
        user.setUpdate_time(new Date());
        System.out.println("Received login request with username: " + username + " and  " + nickname + " and  " + email);
        userMapper.insertUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("注册成功");
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        System.out.println("点击mystation，请求"+ username+"的个人信息");
                User user = userMapper.findByUsername(username);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<String> updateUser(
            @PathVariable String username,
            @RequestParam String nickname,
            @RequestParam String avatar,
            @RequestParam String gender,
            @RequestParam String birthday,
            @RequestParam String email,
            @RequestParam String phone_number) {
        System.out.println("修改个人资料："+username);

        User existingUser = userMapper.findByUsername(username);
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("用户不存在");
        }

        existingUser.setNickname(nickname);
        existingUser.setAvatar(avatar);
        existingUser.setSexy(gender);
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedBirthday = dateFormat.parse(birthday);
            existingUser.setBirthday(parsedBirthday);
        } catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("日期格式不正确");
        }
        existingUser.setEmail(email);
        existingUser.setPhone_number(Double.valueOf(phone_number));
        existingUser.setUpdate_time(new Date());
        System.out.println("修改over");

        userMapper.updateUser(existingUser);
        return ResponseEntity.ok("用户信息更新成功");
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        System.out.println("请求ID为" + id + "的用户信息");
        User user = userMapper.findById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        System.out.println("请求所有用户的信息");
        List<User> users = userMapper.findAll();
        if (users == null || users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{userId}/updateProperty")
    public ResponseEntity<String> updateUserProperty(
            @PathVariable int userId,
            @RequestBody Map<String, Object> requestBody) {
        System.out.println("更新用户资产，用户ID：" + userId);

        // 确保从请求体中获取的值是 Double 类型
        Object propertyObject = requestBody.get("newProperty");
        if (propertyObject instanceof Number) {
            Double newProperty = ((Number) propertyObject).doubleValue();

            User existingUser = userMapper.findById(userId);
            if (existingUser == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("用户不存在");
            }

            existingUser.setProperty(newProperty); // 假设 User 类中有一个 property 字段
            existingUser.setUpdate_time(new Date());

            userMapper.updateUserProperty(userId, newProperty);
            return ResponseEntity.ok("用户资产更新成功");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("无效的资产值");
        }
    }

}
