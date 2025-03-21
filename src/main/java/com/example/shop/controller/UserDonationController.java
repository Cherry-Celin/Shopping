package com.example.shop.controller;

import com.example.shop.entity.UserDonation;
import com.example.shop.mapper.UserDonationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/donations")
public class UserDonationController {

    @Autowired
    private UserDonationMapper userDonationMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserDonation> getDonationById(@PathVariable int id) {
        UserDonation userDonation = userDonationMapper.getDonationById(id);
        if (userDonation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(userDonation);
    }

    @GetMapping
    public ResponseEntity<List<UserDonation>> getAllDonations() {
        List<UserDonation> userDonations = userDonationMapper.getAllDonations();
        return ResponseEntity.ok(userDonations);
    }

    @PutMapping("/{id}/updateDonationAmount")
    public ResponseEntity<String> updateDonationAmount(@PathVariable int id, @RequestBody Map<String, Double> request) {
        double newDonationAmount = request.get("newDonationAmount");
        userDonationMapper.updateDonationAmount(id, newDonationAmount);
        return ResponseEntity.ok("捐赠金额更新成功");
    }

    @PostMapping
    public ResponseEntity<String> createDonation(
            @RequestParam("userId") int userId,
            @RequestParam("projectId") int projectId,
            @RequestParam("amount") Double amount) {
        try {
            userDonationMapper.createDonation(userId, projectId, amount);
            return ResponseEntity.ok("Donation created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating donation");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDonation(@PathVariable int id, @RequestBody UserDonation userDonation) {
        userDonation.setId(id);
        userDonationMapper.updateDonation(userDonation);
        return ResponseEntity.ok("捐赠记录更新成功");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDonation(@PathVariable int id) {
        userDonationMapper.deleteDonation(id);
        return ResponseEntity.ok("捐赠记录删除成功");
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserDonation>> findByUserId(@PathVariable int userId) {
        List<UserDonation> userDonations = userDonationMapper.findByUserId(userId);
        System.out.println(userDonations);
        return ResponseEntity.ok(userDonations);
    }

    @GetMapping("/check")
    public ResponseEntity<Map<String, Boolean>> checkDonation(@RequestParam("userId") int userId,
                                                              @RequestParam("projectId") int projectId) {
        boolean exists = userDonationMapper.existsByUserIdAndProjectId(userId, projectId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }
}
