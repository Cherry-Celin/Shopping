package com.example.shop.controller;

import com.example.shop.entity.CartItem;
import com.example.shop.mapper.CartMapper;
import com.example.shop.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ProductMapper productMapper;

    // 获取购物车商品
    @GetMapping("/{userId}")
    public List<CartItem> getCartItems(@PathVariable int userId) {
        System.out.println("获取用户 " + userId + " 收藏夹");
        List<CartItem> cartItems = cartMapper.getCartItems(userId);
        System.out.println("收藏商品 " + cartItems);
        return cartItems;
    }

    // 删除购物车商品
    @DeleteMapping("/{id}")
    public void deleteCartItem(@PathVariable int id) {
        cartMapper.deleteCartItem(id);
    }

    // 批量删除购物车商品
    @PostMapping("/deleteSelected")
    public void deleteSelectedCartItems(@RequestBody Map<String, List<Integer>> request) {
        List<Integer> ids = request.get("ids");
        cartMapper.deleteSelectedCartItems(ids);
    }

    // 结算
    @PostMapping("/checkout")
    public void checkout(@RequestBody Map<String, Object> request) {
        int userId = (int) request.get("userId");
        List<Integer> productIds = (List<Integer>) request.get("productIds");
        cartMapper.checkout(userId, productIds);
    }

    // 添加商品到购物车
    // 添加商品到购物车
    @PostMapping("/addToCart")
    public String addToCart(@RequestBody Map<String, Integer> request) {
        int userId = request.get("userId");
        int productId = request.get("productId");
        // 检查商品是否已经在购物车中
        if (cartMapper.isProductInCart(userId, productId)) {
            return "商品已存在于收藏夹";
        }
        // 如果不在，则添加到购物车
        cartMapper.addToCart(userId, productId);
        return "商品成功加入收藏夹";
    }

}
