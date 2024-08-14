package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findByName(String name);
}
