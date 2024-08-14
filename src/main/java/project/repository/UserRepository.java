package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long userId);
}
