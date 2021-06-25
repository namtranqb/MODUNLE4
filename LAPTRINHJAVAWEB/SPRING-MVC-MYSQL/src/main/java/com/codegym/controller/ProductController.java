package com.codegym.controller;

import com.codegym.DAO.ProductDAO;
import com.codegym.model.Product;
import com.codegym.service.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ProductController {
    ProductDAO productDAO = new ProductDAO();
    private ProductService productService;

    @RequestMapping("/")
    public String listProduct(Model model) {
        List<Product> productList = productDAO.getAllProduct();
        model.addAttribute("listProduct", productList);
        return "manager-product";
    }


}
