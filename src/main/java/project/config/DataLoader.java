package project.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.model.Product;
import project.model.User;
import project.repository.ProductRepository;
import project.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    public DataLoader(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(userRepository.findAll().isEmpty()){
            List<User> userList = List.of(new User("Felipe", "RJ"),
                    new User("Lucas", "MG"),
                    new User("Pedro", "SP"),
                    new User("Fabiana", "RS"));
            userRepository.saveAll(userList);


            }

        if(productRepository.findAll().isEmpty()){

            User user01 = userRepository.findById(1L).get();
            User user02 = userRepository.findById(2L).get();
            User user03 = userRepository.findById(3L).get();
            User user04 = userRepository.findById(4L).get();

            List<Product> productList = List.of(
                    new Product("Laptop", "Electronics", 74999.99f, 50, user01),
                    new Product("Smartphone", "Electronics", 39999.99f, 100, user02),
                    new Product("Office Chair", "Furniture", 7999.99f, 200, user03),
                    new Product("Notebook", "Stationery", 99.99f, 500, user04),
                    new Product("Desk Lamp", "Furniture", 1999.99f, 150, user03),
                    new Product("Water Bottle", "Accessories", 499.99f, 300, user01));

            productRepository.saveAll(productList);

        }
    }
}
