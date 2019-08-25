package com.demo.controller;

import com.demo.entity.Product;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("findAll")
    public List<Product> findAll(){
        List<Product> list = productService.findAll();
        return list;
    }
}
