package com.demo.service;

import com.demo.dao.ProductDao;
import com.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao = new ProductDao();

    public List<Product> findAll(){
        List<Product> list = (List<Product>) productDao.findAll();
        return list;
    }
}
