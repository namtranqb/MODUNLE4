package com.codegym.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet rs,int rownum) throws SQLException{
        Product product = new Product();
        product.setPid(rs.getInt("pid"));
        product.setPcode(rs.getString("pcode"));
        product.setPname(rs.getString("pname"));
        product.setPrice(rs.getDouble("price"));
        product.setQuantity(rs.getInt("quantity"));
        product.setPimage(rs.getString("pimage"));
        product.setColor(rs.getString("color"));
        product.setDescription(rs.getString("description"));
        return product;
    }
}
