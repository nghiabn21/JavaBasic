package com.example.token;

import com.example.token.domain.Product;
import com.example.token.repo.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductTest {
    @Autowired
    private ProductRepo productRepo ;

    @Test
    public void testCreateProduct(){
        Product product = new Product("iphone 10", 789);
        productRepo.save(product);
    }
}
