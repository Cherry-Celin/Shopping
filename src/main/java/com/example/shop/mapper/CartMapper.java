package com.example.shop.mapper;

import com.example.shop.entity.CartItem;
import com.example.shop.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {

    // 获取购物车商品
    List<CartItem> getCartItems(@Param("userId") int userId);

    // 删除购物车商品
    void deleteCartItem(int id);

    // 批量删除购物车商品
    void deleteSelectedCartItems(@Param("ids") List<Integer> ids);

    // 结算
    void checkout(@Param("userId") int userId, @Param("productIds") List<Integer> productIds);

    void addToCart(@Param("userId") int userId, @Param("productId") int productId);

    boolean isProductInCart(@Param("userId") int userId, @Param("productId") int productId);
}
