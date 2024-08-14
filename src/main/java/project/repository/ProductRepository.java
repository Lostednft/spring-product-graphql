package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {

    public List<Product> findByName(String name);
    public Optional <Product> findById(String idProduct);
}
