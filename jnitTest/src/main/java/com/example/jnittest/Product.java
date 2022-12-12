package com.example.jnittest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(name = "name")
    private String  name ;
    @Column(name = "price")
    private int price ;

    public Product(String s, int i) {
        this.name = s;
        this.price = i ;
    }
}
