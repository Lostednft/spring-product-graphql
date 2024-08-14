package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    public List<Product> findByName(String name);
}
