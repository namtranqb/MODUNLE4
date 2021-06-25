package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;

import com.codegym.model.upload.UploadFile;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;

@Controller

@PropertySource("classpath:upload_file.properties")
public class ProductController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductService productService;

    @Value("${folder-upload}")
    private String folderUpload;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/product")
    public ModelAndView listProducts() {
        Iterable<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("manager/product/index");
        modelAndView.addObject("products", products);
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("uploadFile", new UploadFile());
        return modelAndView;
    }

    @PostMapping("/product")
    public String addProduct(@ModelAttribute("product") Product product, HttpServletRequest request, @ModelAttribute("uploadFile") UploadFile uploadFile) {
        String uploadRootPath = request.getServletContext().getRealPath("/upload/product-img/");
        if (folderUpload.isEmpty()) {
            folderUpload = uploadRootPath;
        }
        File uploadRootDir = new File(uploadRootPath);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }

        CommonsMultipartFile[] filesData = uploadFile.getFilesData();

        for (CommonsMultipartFile fileData : filesData) {

            String fileName = fileData.getOriginalFilename();

            if (fileName != null && fileName.length() > 0) {
                try {
                    File serverFile = new File(folderUpload + fileName);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();

                    product.setImage(fileName);
                    productService.save(product);
                } catch (Exception e) {
                    System.out.println("Error Write file: " + fileName);
                }
            }
        }
//        ModelAndView modelAndView = new ModelAndView("manager/product/index");
//        modelAndView.addObject("product", product);
//        modelAndView.addObject("success", "Created new product successfully !");
//        return modelAndView;
        return "redirect:product";

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("manager/product/index");
            modelAndView.addObject("product", product);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/404");
            return modelAndView;
        }
    }

    @PostMapping("/edit/{id}")
    public ModelAndView updateProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("manager/product/index");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }

//    @GetMapping("/delete/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id) {
//        Optional<Product> product = productService.findById(id);
//        if (product.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("manager/product/delete");
//            modelAndView.addObject("product", product.get());
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("404");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/delete")
//    public String deleteCustomer(@ModelAttribute("product") Product product) {
//        productService.remove(product.getId());
//        return "redirect:product";
//    }

}
