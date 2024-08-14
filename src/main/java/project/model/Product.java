package project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product_tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String categoria;
    private Float price;
    private Integer stock;


    public Product(String name, String categoria, Float price, Integer stock) {
        this.name = name;
        this.categoria = categoria;
        this.price = price;
        this.stock = stock;
    }
}
