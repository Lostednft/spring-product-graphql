package project.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.model.Product;
import project.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Product> productList = List.of(
                new Product(0L, "Laptop", "Electronics", 74999.99f, 50),
                new Product(1L,"Smartphone", "Electronics", 39999.99f, 100),
                new Product(2L,"Office Chair", "Furniture", 7999.99f, 200),
                new Product(3L,"Notebook", "Stationery", 99.99f, 500),
                new Product(4L,"Desk Lamp", "Furniture", 1999.99f, 150),
                new Product(5L,"Water Bottle", "Accessories", 499.99f, 300));

        productRepository.saveAll(productList);
    }
}
