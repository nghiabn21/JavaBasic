package com.example.jnittest;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductTest {
    @Autowired
    private ProductRepo productRepo;

    @Test
    @Rollback(value = false)
    public void testCreateProduct() {
        Product product = new Product("iphone 10", 789);
        Product save1 = productRepo.save(product);
        Assertions.assertNotNull(save1);
    }

    @Test
    public void testFindByNameExit() {
        String product = "iphone 11";
        Product p = productRepo.findByName(product);
        //AssertThat là một trong những phương thức JUnit từ đối tượng Assert
        // có thể được sử dụng để kiểm tra xem một giá trị cụ thể có khớp với giá trị dự kiến hay không.
        //Nó chủ yếu chấp nhận 2 tham số.
        // Cái đầu tiên nếu giá trị thực tế và cái thứ hai là một đối tượng khớp.
        // Sau đó, nó sẽ cố gắng so sánh hai điều này và trả về một kết quả boolean nếu đó là một trận đấu hay không.
        MatcherAssert.assertThat(p.getName(),equalTo(product));

    }

    @Test
    @Rollback(value = false)
    public void testFindByNameNotExit() {
        String product = "iphone 11";
        Product p = new Product(product, 789);
        p.setId(1);
        productRepo.save(p);
        // không tìm thấy tức là object null
        Assertions.assertNotNull(p);
    }






    @Test
    public void testListProducts() {
        List<Product> products = productRepo.findAll();
        assertThat(products.size()).isGreaterThan(0);
    }
}
