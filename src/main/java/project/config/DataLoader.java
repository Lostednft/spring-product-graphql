package project.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.model.Product;
import project.repository.ProductRepository;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Product> productList = List.of(
                new Product("Laptop", "Electronics", 74999.99f, 50),
                new Product("Smartphone", "Electronics", 39999.99f, 100),
                new Product("Office Chair", "Furniture", 7999.99f, 200),
                new Product("Notebook", "Stationery", 99.99f, 500),
                new Product("Desk Lamp", "Furniture", 1999.99f, 150),
                new Product("Water Bottle", "Accessories", 499.99f, 300));

        productRepository.saveAll(productList);
    }
}
