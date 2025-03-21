package com.example.shop.controller;

import com.example.shop.entity.Type;
import com.example.shop.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    @Autowired
    private TypeMapper typeMapper;

    @GetMapping
    public List<Type> getAllTypes() {
        return typeMapper.getAllTypes();
    }
}
