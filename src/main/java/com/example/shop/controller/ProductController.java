package com.example.shop.controller;

import com.example.shop.entity.Product;
import com.example.shop.entity.User;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;

    // 根据ID获取产品
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        Product product = productMapper.getProductById(id);
        System.out.println("Fetched Product: " + product.getUser().getId());
        return product;
    }

    // 新增随机返回20个产品的路由
    @GetMapping("/random")
    public List<Product> getRandomProducts() {
        List<Product> products = productMapper.getRandomProducts();
        System.out.println("Fetched Random Products: " + products.size());
        return products;
    }

    // 根据typeID获取产品
    @GetMapping("/type/{typeId}")
    public List<Product> getProductsByTypeId(@PathVariable int typeId) {
        List<Product> products = productMapper.getProductsByTypeId(typeId);
        System.out.println("Fetched Products by type "+typeId+";" + products.size());
        return products;
    }

    // 根据关键词搜索产品
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String query) {
        List<Product> products = productMapper.searchProductsByQuery(query);
        System.out.println("Fetched Products by search query '" + query + "': " + products.size());
        return products;
    }

    // 获取所有产品
    @GetMapping
    public List<Product> getAllProducts() {
        List<Product> products = productMapper.getAllProducts();
        System.out.println("Fetched Products: " + products);
        return products;
    }

    // 根据用户名获取已经发布的产品
    @GetMapping("/user_published/{username}")
    public List<Product> getPublishedProductsByUsername(@PathVariable String username) {
        List<Product> products = productMapper.getPublishedProductsByUsername(username);
        System.out.println("Fetched Products by username " + username + "已经发布: " + products.size());
        return products;
    }

    // 根据用户名获取已经发布的产品
    @GetMapping("/user_drafts/{username}")
    public List<Product> getDraftProductsByUsername(@PathVariable String username) {
        List<Product> products = productMapper.getDraftProductsByUsername(username);
        System.out.println("Fetched Products by username " + username + "保存编辑中: " + products.size());
        return products;
    }

    // 根据用户名获取已经发布的产品
    @GetMapping("/user_unpublished/{username}")
    public List<Product> getUnPublishedProductsByUsername(@PathVariable String username) {
        List<Product> products = productMapper.getUnPublishedProductsByUsername(username);
        System.out.println("Fetched Products by username " + username + "已下架: " + products.size());
        return products;
    }

    // 插入新商品
    @PostMapping("/insert")
    public void insertProduct(
            @RequestParam("productName") String productName,
            @RequestParam("price") Double price,
            @RequestParam("imgUrl") String imgUrl,
            @RequestParam("description") String description,
            @RequestParam("status") String status,
            @RequestParam("ways") String ways,
            @RequestParam("donationPercent") Double donationPercent,
            @RequestParam("username") String username,
            @RequestParam("location") String location,
            @RequestParam("detailAddress") String detailAddress,
            @RequestParam("postage") Double postage
    ) {
        // 构造 Product 对象
        Product product = new Product();
        product.setProduct_name(productName);
        product.setPrice(price);
        product.setDescription(description);
        product.setStatus(status);
        product.setWays(ways);
        product.setDonation_percent(donationPercent);
        product.setImg_url(imgUrl);
        product.setIs_deleted(Boolean.FALSE);

        System.out.println("开始插入商品啦 " + product);

        // 构造 User 对象，设置用户ID和地址信息
        User user = new User();
        user.setUsername(username);
        user.setLocation(location);
        user.setDetail_address(detailAddress);
        Date updateTime = new Date();
        user.setUpdate_time(updateTime);
        // 可能还有其他用户相关的字段设置

        // 获取用户ID
        int userId = userMapper.findByUsername(username).getId();


        System.out.println("谁开始插入商品啦 " + userId);
        user.setId(userId);

        // 将 User 对象设置到 Product 中
        product.setUser(user);

        // 设置其他商品相关的信息
        product.setPostage(postage);

        // 设置商品的其他属性
        product.setCreate_time(LocalDateTime.now());
        product.setUpdate_time(LocalDateTime.now());
        product.setPublish_start(LocalDateTime.now());

        // 执行插入操作
        productMapper.insertProduct(product);

        // 更新用户的地址信息，这里假设 ProductMapper 中有一个 updateUserAddress 方法来更新用户的地址信息
        productMapper.updateUserAddress(username, location, detailAddress,updateTime);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateProduct(
            @RequestParam("productId") int productId,
            @RequestParam("productName") String productName,
            @RequestParam("price") Double price,
            @RequestParam("imgUrl") String imgUrl,
            @RequestParam("description") String description,
            @RequestParam("status") String status,
            @RequestParam("ways") String ways,
            @RequestParam("donationPercent") Double donationPercent,
            @RequestParam("username") String username,
            @RequestParam("location") String location,
            @RequestParam("detailAddress") String detailAddress,
            @RequestParam("postage") Double postage
    ) {
        // 查找商品
        Product product = productMapper.getProductById(productId);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("商品未找到");
        }

        // 更新商品信息
        product.setProduct_name(productName);
        product.setPrice(price);
        product.setImg_url(imgUrl);
        product.setDescription(description);
        product.setStatus(status);
        product.setWays(ways);
        product.setDonation_percent(donationPercent);
        product.setPostage(postage);
        product.setUpdate_time(LocalDateTime.now());

        // 执行更新操作
        productMapper.updateProduct(product);

        // 更新用户地址信息
        User user = userMapper.findByUsername(username);
        if (user != null) {
            user.setLocation(location);
            user.setDetail_address(detailAddress);
            user.setUpdate_time(new Date());
            userMapper.updateUser(user);
        }

        return ResponseEntity.ok("商品更新成功");
    }

    // 删除产品
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Product product = productMapper.getProductById(id);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("商品未找到");
        }
        productMapper.deleteProduct(id);
        return ResponseEntity.ok("商品删除成功");
    }


    @PutMapping("/{productId}/unpublish")
    public ResponseEntity<String> unpublishProduct(@PathVariable int productId) {
        // 查找商品
        Product product = productMapper.getProductById(productId);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("商品未找到");
        }

        // 更新商品状态为UNPUBLISHED
        product.setStatus("UNPUBLISHED");
        product.setUpdate_time(LocalDateTime.now());
        productMapper.updateProduct(product);
        System.out.println("使得"+productId+"下架"+product.getStatus());

        return ResponseEntity.ok("商品状态已更新为 UNPUBLISHED");
    }



}
