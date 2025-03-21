package com.example.shop.mapper;

import com.example.shop.entity.Product;
import com.example.shop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ProductMapper {

    // 插入产品
    void insertProduct(Product product);

    // 根据ID获取产品
    Product getProductById(int id);

    // 根据typeID获取产品
    List<Product> getProductsByTypeId(@Param("typeId") int type_id);

    // 根据关键词搜索产品
    List<Product> searchProductsByQuery(@Param("query") String query);

    List<Product> getRandomProducts();

    // 更新产品信息
    void updateProduct(Product product);

    // 删除产品
    void deleteProduct(int id);

    // 获取所有产品
    List<Product> getAllProducts();

    // 更新用户地址信息
    void updateUserAddress(@Param("username") String username, @Param("location") String location, @Param("detailAddress") String detailAddress, @Param("updateTime") Date updateTime);


    // 获取一个用户发布的所有产品
    List<Product> getPublishedProductsByUsername(@Param("username") String username);
    // 获取一个用户发布的所有产品
    List<Product> getDraftProductsByUsername(@Param("username") String username);
    // 获取一个用户发布的所有产品
    List<Product> getUnPublishedProductsByUsername(@Param("username") String username);


}
