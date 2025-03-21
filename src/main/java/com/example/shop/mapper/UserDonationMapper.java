package com.example.shop.mapper;

import com.example.shop.entity.UserDonation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDonationMapper {

    UserDonation getDonationById(@Param("id") int id);

    List<UserDonation> getAllDonations();


    void updateDonation(UserDonation userDonation);

    void deleteDonation(@Param("id") int id);

    List<UserDonation> findByUserId(@Param("userId") int userId);

    void updateDonationAmount(@Param("id") int id, @Param("newDonationAmount") double newDonationAmount);

    boolean existsByUserIdAndProjectId(@Param("userId") int userId, @Param("projectId") int projectId);

    void createDonation(
            @Param("userId") int userId,
            @Param("projectId") int projectId,
            @Param("amount") Double amount);
}
