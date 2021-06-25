package com.codegym.DAO;

import com.codegym.model.Product;
import com.codegym.model.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
public class ProductDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getAllProduct(){
        String query = " SELECT * FROM product";
        return jdbcTemplate.query(query,new ProductMapper());
    }

    public Product getProductByID(int id){
        String query = " select * from product where pid = ?";

        return null;
    }

    public List<Product> searchProduct(String keyword){
        List<Product> products = new ArrayList<>();
        String query = " SELECT * FROM product where pname like ? or price like ? or color like ? or pcode like ?";

        return products;
    }


    public void insertProduct(Product product, int cid) throws SQLException {
        String INSERT_PRODUCT ="INSERT INTO product(pcode,pname,price,quantity,pimage,color,`description`,cid) VALUES (?,?,?,?,?,?,?,?)";


    }

    public void updateProduct(Product product, int cid) throws SQLException {
        String UPDATE_PRODUCT ="UPDATE product set pcode = ?,pname = ?,price = ?,quantity = ?,pimage = ?,color = ?,`description` = ?,cid = ? where pid = ?";

    }


    public boolean deleteProduct(int id) throws SQLException {

        return true;
    }
}
