package project.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import project.model.Product;
import project.model.ProductDTO;
import project.repository.ProductRepository;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryMapping
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @QueryMapping
    public List<Product> productByName(@Argument String name){
        return productRepository.findByName(name);
    }

    @MutationMapping
    public Product createProduct(@Argument("Product") ProductDTO productDTO){
        return productRepository.save(new Product(productDTO));
    }
}
