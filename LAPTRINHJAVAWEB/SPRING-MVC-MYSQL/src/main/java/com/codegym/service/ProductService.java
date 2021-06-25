package com.codegym.service;

import com.codegym.DAO.ProductDAO;
import com.codegym.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    public List<Product> findAll(){
        return productDAO.getAllProduct();
    }
}
