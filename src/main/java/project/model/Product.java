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
    private String category;
    private Float price;
    private Integer stock;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Product(String name, String category, Float price, Integer stock, User user) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.user = user;
    }

    public Product(ProductDTO productDTO) {
        this.name = productDTO.name();
        this.category = productDTO.category();
        this.price = productDTO.price();
        this.stock = productDTO.stock();
        this.user = productDTO.user();
    }

}
