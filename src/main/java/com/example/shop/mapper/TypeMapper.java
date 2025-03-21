package com.example.shop.mapper;

import com.example.shop.entity.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {

    List<Type> getAllTypes();
}
