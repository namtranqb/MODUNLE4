package com.codegym.formatter;

import com.codegym.model.Category;
import com.codegym.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class CategoryFormatter implements Formatter<Category> {
    private ICategoryService categoryService;

    @Autowired
   public CategoryFormatter(ICategoryService categoryService){
       this.categoryService = categoryService;
   }

    @Override
    public Category parse(String s, Locale locale) throws ParseException {
        Optional<Category> categoryOptional = categoryService.findById(Long.parseLong(s));

        return categoryOptional.orElse(null);
    }

    @Override
    public String print(Category category, Locale locale) {
        return "["+category.getCategoryId()+", "+category.getCategoryName()+"]";
    }
}
