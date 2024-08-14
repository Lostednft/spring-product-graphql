package project.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //@Argument tem quer o msm nome da Classe
    @MutationMapping
    public Product createProduct(@Argument("Product") ProductDTO productDTO){
        return productRepository.save(new Product(productDTO));
    }

    //@Argument tem quer o msm nome do que o atributo "id"
    @MutationMapping
    public String deleteProduct(@Argument("id") String idProduct){
        Product productById = productRepository.findById(idProduct).orElseThrow(() -> new RuntimeException("Esse ID não existe"));
        productRepository.delete(productById);
        return "Deletado com Sucesso!";
    }

    @MutationMapping
    public Product updateProduct(@Argument String id, @Argument ProductDTO Product){

        if(productRepository.findById(id).isEmpty())
            throw new RuntimeException("Esse PRODUTO não existe");

        Product newProduct = new Product(Product);
        newProduct.setId(id);
        return productRepository.save(newProduct);
    }
}
