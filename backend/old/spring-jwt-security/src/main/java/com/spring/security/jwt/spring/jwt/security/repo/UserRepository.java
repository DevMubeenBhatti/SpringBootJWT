package com.spring.security.jwt.spring.jwt.security.repo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.security.jwt.spring.jwt.security.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}
