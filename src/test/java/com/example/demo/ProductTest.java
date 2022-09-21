package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;



import java.util.List;
import java.util.Optional;



import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



import com.example.demo.Repository.ProductRepository;
import com.example.demo.controller.products;



@DataJpaTest





@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductTest {
    @Autowired
    public ProductRepository prepository;
    Optional<products> p1;
    
    /*@Test
     public void getEmployeeTest(){





      product prod = prepository.findById((long) 11).get();
        //Assertions.assertThat(prod.getProd_id()).isEqualTo((long)11);
        System.out.println(prod);
    } */
    
      @Test
      public void getAllProductsTest(){





          List<products> products = prepository.findAll();
            Assertions.assertThat(products.size()).isEqualTo(2);
            
            System.out.println(products);
        }
}